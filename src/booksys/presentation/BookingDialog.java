/*
 * Restaurant Booking System: example code to accompany
 *
 * "Practical Object-oriented Design with UML"
 * Mark Priestley
 * McGraw-Hill (2004)
 */

package booksys.presentation ;

import booksys.application.domain.Booking ;
import booksys.application.domain.BookingSystem ;


import java.awt.* ;
import java.awt.event.* ;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date ;
import java.sql.Time ;
import java.util.Calendar ;
import java.util.Enumeration ;

abstract class BookingDialog extends Dialog
{
  protected Choice    tableNumber ;
  protected TextField covers ;
  protected TextField time ;
  protected TextField menu ;
  protected Label     tableNumberLabel ;
  protected Label     coversLabel ;
  protected Label     timeLabel ;
  protected Button	  menuButton ;
  protected boolean   confirmed ;
  protected Button    ok ;
  protected Button    cancel ;
  
  BookingDialog(Frame owner, String title)
  {
    this(owner, title, null) ;
  }

  // This constructor initializes fields with data from an existing booking.
  // This is useful for completing Exercise 7.6.
  
  BookingDialog(Frame owner, String title, Booking booking)
  {
    super(owner, title, true) ;
    
    addWindowListener(new WindowAdapter() {
	public void windowClosing(WindowEvent e) {
	  confirmed = false ;
	  BookingDialog.this.hide() ;
	}
      }) ;
    
    tableNumberLabel = new Label("Table number:", Label.RIGHT) ;
    tableNumber = new Choice() ;
    Enumeration enums = BookingSystem.getTableNumbers().elements() ;
    while (enums.hasMoreElements()) {
      tableNumber.add(((Integer) enums.nextElement()).toString()) ;
    }
    if (booking != null) {
      tableNumber.select(Integer.toString(booking.getTable().getNumber())) ;
    }

    
    coversLabel = new Label("Covers:", Label.RIGHT) ;
    covers = new TextField(4) ;
    if (booking != null) {
      covers.setText(Integer.toString(booking.getCovers())) ;
    }
    
    
    timeLabel = new Label("Time:", Label.RIGHT) ;
    time = new TextField("HH:MM:SS", 8) ;
    if (booking != null) {
      time.setText(booking.getTime().toString()) ;
    }
    
    menuButton=new Button("Menu:");
    menu=new TextField(8);
    if(booking != null) {
    	menu.setText(booking.getMenu());
    }
    
    ok = new Button("Ok") ;
    ok.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
	  confirmed = true ;
	  BookingDialog.this.hide() ;
	}
      }) ;
    
    cancel = new Button("Cancel") ;
    cancel.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
	  confirmed = false ;
	  BookingDialog.this.hide() ;
	}
      }) ;
  }
  
  int getTableNumber()
  {
    return Integer.parseInt(tableNumber.getSelectedItem()) ;
  }

  int getCovers()
  {
    return Integer.parseInt(covers.getText()) ;
  }

  Time getTime()
  {
    return Time.valueOf(time.getText()) ;
  }
  
  String getMenu()
  {
	  return menu.getText();
  }

  boolean isConfirmed()
  {
    return confirmed ;
  }
}
