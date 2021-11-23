/*
 * Restaurant Booking System: example code to accompany
 *
 * "Practical Object-oriented Design with UML"
 * Mark Priestley
 * McGraw-Hill (2004)
 */

package booksys.presentation ;

import booksys.application.domain.Reservation ;

import java.awt.* ;
import java.awt.event.* ;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

class ReservationDialog extends BookingDialog
{
  protected TextField name ;
  protected TextField phone ;
  protected Label     nameLabel ;
  protected Label     phoneLabel ;
  protected Button	  menuButton;
  protected TextField menu;
  
  ReservationDialog(Frame owner, String title)
  {
    this(owner, title, null) ;
  }

  // This constructor initializes fields with data from an existing booking.
  // This is useful for completing Exercise 7.6.
  
  ReservationDialog(Frame owner, String title, Reservation r)
  {
    super(owner, title, r) ;

   
    nameLabel = new Label("Name:", Label.RIGHT) ;
    name = new TextField(30) ;
    if (r != null) {
      name.setText(r.getCustomer().getName()) ;
    }

    phoneLabel = new Label("Phone no:", Label.RIGHT) ;
    phone = new TextField(15) ;
    if (r != null) {
      phone.setText(r.getCustomer().getPhoneNumber()) ;
    }
    
    menuButton=new Button("Menu:");
    menu=new TextField(15);
    if(r!=null) {
    	menu.setText(r.getMenu());
    }
    menuButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			MenuDialog md=new MenuDialog(owner,title,r);
			md.show();
			String allMenu="";
			Iterator it=md.menuName.iterator();
			while(it.hasNext()) {
				allMenu+=it.next();
			}
			menu.setText(allMenu+" "+md.allPrice);
		}
    });
    
    // Lay out components in dialog
    
    setLayout( new GridLayout(0, 2) ) ;

    add(timeLabel) ;
    add(time) ;

    add(nameLabel) ;
    add(name) ;

    add(phoneLabel) ;
    add(phone) ;
    
    add(coversLabel) ;
    add(covers) ;

    add(tableNumberLabel) ;
    add(tableNumber) ;
    
    add(menuButton);
    add(menu);
    
    add(ok) ;
    add(cancel) ;
    
    pack() ;
  }

  String getCustomerName()
  {
    return name.getText() ;
  }

  String getPhoneNumber()
  {
    return phone.getText() ;
  }
  
  String getMenu() {
	  return menu.getText();
  }
}
