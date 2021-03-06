package mainpackage;
/* 
 * Filename: OOPDraw2.java 
 * Written By: Sunit Katkar 
 * E-Mail:sunitkatkar@hotmail.com 
 * Home-Page : http://www.vidyut.com/sunit 
 * Java Page : www.vidyut.com/sunit/JavaPage.html 
 ****************************************************************** 
 * Description: 
 * A very simple vector drawing example. I have used the OO concept 
 * of Polymorphism to declare on abstract Shape class and then derived  
 * line, rectangle and oval shape classes. The shapes are stored in a 
 * Vector so that they remain on screen as new shapes are drawn. 
 * An offscreen image technique is used to avoid flicker. 
 **************************************************************** 
 * Copyright (c) 1997 Sunit Katkar All Rights Reserved. 
 * 
 * Permission to use, copy, modify, and distribute this software 
 * for NON-COMMERCIAL or COMMERCIAL purposes and without fee 
 * is hereby granted. 
 * 
 * Whew ! That was too much legalese..even to have copied and pasted 
 * from some other place... PLEASE DO NOT BLAME ME in any way 
 * if your system crashes because of this code, or if anything else 
 * bad happens. In short "DO WHAT YOU WANT BUT DONT BLAME ME !" 
 *****************************************************************/
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.HashSet;

import javax.swing.JFrame;

import shapes.AbstractShape;
import composers.ShapeComposer;
import composers.ShapeComposerFactory;
/**
 * Filename: OOPDraw2.java<br/>
 * Written By: Sunit Katkar<br/>
 * E-Mail:sunitkatkar@hotmail.com<br/>
 * Home-Page : [url]http://www.vidyut.com/sunit[/url]<br/>
 * Java Page : [url]www.vidyut.com/sunit/JavaPage.html[/url]
 * <p/>
 *******************************************************************************<p/>
 * Description: A very simple vector drawing example. I have used the OO concept
 * of Polymorphism to declare on abstract Shape class and then derived line,
 * rectangle and oval shape classes. The shapes are stored in a Vector so that
 * they remain on screen as new shapes are drawn. An offscreen image technique
 * is used to avoid flicker.
 * <p/>
 *******************************************************************************<p/>
 * Copyright (c) 1997 Sunit Katkar All Rights Reserved.
 * <p/>
 * 
 * Permission to use, copy, modify, and distribute this software for
 * NON-COMMERCIAL or COMMERCIAL purposes and without fee is hereby granted.
 * <p/>
 * 
 * Whew ! That was too much legalese..even to have copied and pasted from some
 * other place... PLEASE DO NOT BLAME ME in any way if your system crashes
 * because of this code, or if anything else bad happens. In short
 * "DO WHAT YOU WANT BUT DONT BLAME ME !"
 * <p/>
 *******************************************************************************<p/>
 * This code was modified by BugSlayer to change it from an applet into a
 * desktop application. Also, refactored the code a little bit to comply to
 * naming conventioned, infomration hiding and several other basic OO
 * principles.
 * <p/>
 ******************************************************************************/
public class OOPDraw extends JFrame implements MouseListener, MouseMotionListener {

	private static final long serialVersionUID = 4695753453561082104L;

	//ArrayList for storing the shapes
	private HashSet<AbstractShape> shapeList;

	//The current composer to be used for composing shapes
	private ShapeComposer currentComposer;
	
	/**
	 * Main method
	 * @param args
	 */
	public static void main(String[] args) {
		OOPDraw frame = new OOPDraw();
		frame.setVisible(true);
	}

	/**
	 * Constructor
	 * Initialises the shapelist and sets current composer to a line composer
	 * Initialises the GUI
	 */
	public OOPDraw() {
		shapeList = new HashSet<AbstractShape>();
		initGUI();
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// Nothing TO DO in this method
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// Nothing TO DO in this method
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// Nothing TO DO in this method
	}

	/**
	 * What to do when the mouse button is pressed.
	 */
	@Override
	public void mousePressed(MouseEvent arg0) {
		int x = arg0.getX();
		int y = arg0.getY();
		shapeList.add(currentComposer.create(new Point(x,y)));
	}
	
	/**
	 * Mouse Drag i.e. Left mouse button is down and mouse is being moved
	 * 
	 * @see
	 * java.awt.event.MouseMotionListener#mouseDragged(java.awt.event.MouseEvent
	 * )
	 */
	@Override
	public void mouseDragged(MouseEvent arg0) {
		int x = arg0.getX();
		int y = arg0.getY();
		shapeList.add(currentComposer.expand(new Point(x,y)));
		repaint();
	}
	
	/**
	 * What to do when the mouse button is released.
	 */
	@Override
	public void mouseReleased(MouseEvent arg0) {
		int x = arg0.getX();
		int y = arg0.getY();
		shapeList.add(currentComposer.complete(new Point(x,y)));
		repaint();
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// Nothing TO DO in this method
	}

	/**
	 * Paint method overridden for custom rendering of the screen
	 * 
	 * @see java.awt.Container#paint(java.awt.Graphics)
	 */
	@Override
	public void paint(Graphics g) {
		// To get a shadow effect
		g.setColor(Color.black);
		g.fillRect(0, 0, getSize().width, getSize().height);
		g.setColor(new Color(255, 255, 154));
		g.fillRect(1, 1, getSize().width - 3, getSize().height - 3);
		for (AbstractShape shape:shapeList) {
			shape.Draw((Graphics2D) g);
		}
	}

	/**
	 * method initializes GUI components
	 */
	private void initGUI() {
		setSize(800, 600);
		setTitle("POSE 2.0 hairy drawing tool");
		setLayout(new FlowLayout());
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		ShapeComposerFactory factory = ShapeComposerFactory.getInstance();
		// Create and Add the buttons
		for (String name : factory.listComposerNames()) {
			Button button = new Button(name);
			final ShapeComposer newComposer = factory.createComposer(name);
			currentComposer = newComposer;
			button.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					currentComposer = newComposer;
				}
			});
			add(button);
		};
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
