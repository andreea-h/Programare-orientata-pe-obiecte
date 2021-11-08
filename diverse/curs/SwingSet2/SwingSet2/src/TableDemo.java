/*
 * @(#)TableDemo.java	1.17 04/07/26
 * 
 * Copyright (c) 2004 Sun Microsystems, Inc. All Rights Reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 
 * -Redistribution of source code must retain the above copyright notice, this
 *  list of conditions and the following disclaimer.
 * 
 * -Redistribution in binary form must reproduce the above copyright notice, 
 *  this list of conditions and the following disclaimer in the documentation
 *  and/or other materials provided with the distribution.
 * 
 * Neither the name of Sun Microsystems, Inc. or the names of contributors may 
 * be used to endorse or promote products derived from this software without 
 * specific prior written permission.
 * 
 * This software is provided "AS IS," without a warranty of any kind. ALL 
 * EXPRESS OR IMPLIED CONDITIONS, REPRESENTATIONS AND WARRANTIES, INCLUDING
 * ANY IMPLIED WARRANTY OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE
 * OR NON-INFRINGEMENT, ARE HEREBY EXCLUDED. SUN MIDROSYSTEMS, INC. ("SUN")
 * AND ITS LICENSORS SHALL NOT BE LIABLE FOR ANY DAMAGES SUFFERED BY LICENSEE
 * AS A RESULT OF USING, MODIFYING OR DISTRIBUTING THIS SOFTWARE OR ITS
 * DERIVATIVES. IN NO EVENT WILL SUN OR ITS LICENSORS BE LIABLE FOR ANY LOST 
 * REVENUE, PROFIT OR DATA, OR FOR DIRECT, INDIRECT, SPECIAL, CONSEQUENTIAL, 
 * INCIDENTAL OR PUNITIVE DAMAGES, HOWEVER CAUSED AND REGARDLESS OF THE THEORY 
 * OF LIABILITY, ARISING OUT OF THE USE OF OR INABILITY TO USE THIS SOFTWARE, 
 * EVEN IF SUN HAS BEEN ADVISED OF THE POSSIBILITY OF SUCH DAMAGES.
 * 
 * You acknowledge that this software is not designed, licensed or intended
 * for use in the design, construction, operation or maintenance of any
 * nuclear facility.
 */

/*
 * @(#)TableDemo.java	1.17 04/07/26
 */


import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;
import javax.swing.table.*;
import javax.swing.border.*;
import javax.swing.colorchooser.*;
import javax.swing.filechooser.*;
import javax.accessibility.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.print.PrinterException;
import java.beans.*;
import java.util.*;
import java.io.*;
import java.applet.*;
import java.net.*;

import java.text.MessageFormat;

/**
 * Table demo
 *
 * @version 1.17 07/26/04
 * @author Philip Milne
 * @author Steve Wilson
 */
public class TableDemo extends DemoModule {
    JTable      tableView;
    JScrollPane scrollpane;
    Dimension   origin = new Dimension(0, 0);
    
    JCheckBox   isColumnReorderingAllowedCheckBox;
    JCheckBox   showHorizontalLinesCheckBox;
    JCheckBox   showVerticalLinesCheckBox;

    JCheckBox   isColumnSelectionAllowedCheckBox;
    JCheckBox   isRowSelectionAllowedCheckBox;

    JLabel      interCellSpacingLabel;
    JLabel      rowHeightLabel;

    JSlider     interCellSpacingSlider;
    JSlider     rowHeightSlider;

    JComboBox	selectionModeComboBox = null;
    JComboBox	resizeModeComboBox = null;

    JLabel      headerLabel;
    JLabel      footerLabel;

    JTextField  headerTextField;
    JTextField  footerTextField;

    JCheckBox   fitWidth;
    JButton     printButton;

    JPanel      controlPanel;
    JScrollPane tableAggregate;

    String path = "ImageClub/food/";

    final int INITIAL_ROWHEIGHT = 33;

    /**
     * main method allows us to run as a standalone demo.
     */
    public static void main(String[] args) {
	TableDemo demo = new TableDemo(null);
	demo.mainImpl();
    }

    /**
     * TableDemo Constructor
     */
    public TableDemo(SwingSet2 swingset) {
	super(swingset, "TableDemo", "toolbar/JTable.gif");
	
	getDemoPanel().setLayout(new BorderLayout());
	controlPanel = new JPanel();
        controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.X_AXIS));
	JPanel cbPanel = new JPanel(new GridLayout(3, 2));
        JPanel labelPanel = new JPanel(new GridLayout(2, 1)) {
            public Dimension getMaximumSize() {
                return new Dimension(getPreferredSize().width, super.getMaximumSize().height);
            }
        };
        JPanel sliderPanel = new JPanel(new GridLayout(2, 1)) {
            public Dimension getMaximumSize() {
                return new Dimension(getPreferredSize().width, super.getMaximumSize().height);
            }
        };
	JPanel comboPanel = new JPanel(new GridLayout(2, 1));
        JPanel printPanel = new JPanel(new ColumnLayout());

	getDemoPanel().add(controlPanel, BorderLayout.NORTH);
	Vector relatedComponents = new Vector();


        // check box panel
    	isColumnReorderingAllowedCheckBox = new JCheckBox(getString("TableDemo.reordering_allowed"), true);
        isColumnReorderingAllowedCheckBox.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
	        boolean flag = ((JCheckBox)e.getSource()).isSelected();
                tableView.getTableHeader().setReorderingAllowed(flag);
                tableView.repaint();
	    }
        });

    	showHorizontalLinesCheckBox = new JCheckBox(getString("TableDemo.horz_lines"), true);
        showHorizontalLinesCheckBox.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
	        boolean flag = ((JCheckBox)e.getSource()).isSelected();
                tableView.setShowHorizontalLines(flag); ;
                tableView.repaint();
	    }
        });

    	showVerticalLinesCheckBox = new JCheckBox(getString("TableDemo.vert_lines"), true);
        showVerticalLinesCheckBox.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
	        boolean flag = ((JCheckBox)e.getSource()).isSelected();
                tableView.setShowVerticalLines(flag); ;
                tableView.repaint();
	    }
        });

	// Show that showHorizontal/Vertical controls are related
	relatedComponents.removeAllElements();
	relatedComponents.add(showHorizontalLinesCheckBox);
	relatedComponents.add(showVerticalLinesCheckBox);
	buildAccessibleGroup(relatedComponents);

        isRowSelectionAllowedCheckBox = new JCheckBox(getString("TableDemo.row_selection"), true);
        isRowSelectionAllowedCheckBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                boolean flag = ((JCheckBox)e.getSource()).isSelected();
                tableView.setRowSelectionAllowed(flag); ;
                tableView.repaint();
            }
        });

        isColumnSelectionAllowedCheckBox = new JCheckBox(getString("TableDemo.column_selection"), false);
        isColumnSelectionAllowedCheckBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                boolean flag = ((JCheckBox)e.getSource()).isSelected();
                tableView.setColumnSelectionAllowed(flag); ;
                tableView.repaint();
            }
        });

        // Show that row/column selections are related
        relatedComponents.removeAllElements();
        relatedComponents.add(isColumnSelectionAllowedCheckBox);
        relatedComponents.add(isRowSelectionAllowedCheckBox);
        buildAccessibleGroup(relatedComponents);

        cbPanel.add(isColumnReorderingAllowedCheckBox);
        cbPanel.add(isRowSelectionAllowedCheckBox);
        cbPanel.add(showHorizontalLinesCheckBox);
        cbPanel.add(isColumnSelectionAllowedCheckBox);
        cbPanel.add(showVerticalLinesCheckBox);


        // label panel
        interCellSpacingLabel = new JLabel(getString("TableDemo.intercell_spacing_colon"));
	labelPanel.add(interCellSpacingLabel);

        rowHeightLabel = new JLabel(getString("TableDemo.row_height_colon"));
        labelPanel.add(rowHeightLabel);


        // slider panel
    	interCellSpacingSlider = new JSlider(JSlider.HORIZONTAL, 0, 10, 1);
	interCellSpacingSlider.getAccessibleContext().setAccessibleName(getString("TableDemo.intercell_spacing"));
	interCellSpacingLabel.setLabelFor(interCellSpacingSlider);
        sliderPanel.add(interCellSpacingSlider);
        interCellSpacingSlider.addChangeListener(new ChangeListener() {
	    public void stateChanged(ChangeEvent e) {
	        int spacing = ((JSlider)e.getSource()).getValue();
                tableView.setIntercellSpacing(new Dimension(spacing, spacing));
                tableView.repaint();
	    }
        });
	
    	rowHeightSlider = new JSlider(JSlider.HORIZONTAL, 5, 100, INITIAL_ROWHEIGHT);
	rowHeightSlider.getAccessibleContext().setAccessibleName(getString("TableDemo.row_height"));
	rowHeightLabel.setLabelFor(rowHeightSlider);
        sliderPanel.add(rowHeightSlider);
        rowHeightSlider.addChangeListener(new ChangeListener() {
	    public void stateChanged(ChangeEvent e) {
	        int height = ((JSlider)e.getSource()).getValue();
                tableView.setRowHeight(height);
                tableView.repaint();
	    }
        });

	// Show that spacing controls are related
	relatedComponents.removeAllElements();
	relatedComponents.add(interCellSpacingSlider);
	relatedComponents.add(rowHeightSlider);
	buildAccessibleGroup(relatedComponents);


        // Create the table.
        tableAggregate = createTable();
        getDemoPanel().add(tableAggregate, BorderLayout.CENTER);


        // ComboBox for selection modes.
	JPanel selectMode = new JPanel();
        selectMode.setLayout(new BoxLayout(selectMode, BoxLayout.X_AXIS));
      	selectMode.setBorder(new TitledBorder(getString("TableDemo.selection_mode")));


        selectionModeComboBox = new JComboBox() {
            public Dimension getMaximumSize() {
                return getPreferredSize();
            }
        };
        selectionModeComboBox.addItem(getString("TableDemo.single"));
        selectionModeComboBox.addItem(getString("TableDemo.one_range"));
        selectionModeComboBox.addItem(getString("TableDemo.multiple_ranges"));
        selectionModeComboBox.setSelectedIndex(tableView.getSelectionModel().getSelectionMode());
        selectionModeComboBox.addItemListener(new ItemListener() {
	    public void itemStateChanged(ItemEvent e) {
	        JComboBox source = (JComboBox)e.getSource();
                tableView.setSelectionMode(source.getSelectedIndex());
	    }
        });

        selectMode.add(Box.createHorizontalStrut(2));
	selectMode.add(selectionModeComboBox);
        selectMode.add(Box.createHorizontalGlue());
        comboPanel.add(selectMode);

        // Combo box for table resize mode.
	JPanel resizeMode = new JPanel();
        resizeMode.setLayout(new BoxLayout(resizeMode, BoxLayout.X_AXIS));
	resizeMode.setBorder(new TitledBorder(getString("TableDemo.autoresize_mode")));


        resizeModeComboBox = new JComboBox() {
            public Dimension getMaximumSize() {
                return getPreferredSize();
            }
        };
        resizeModeComboBox.addItem(getString("TableDemo.off"));
        resizeModeComboBox.addItem(getString("TableDemo.column_boundaries"));
        resizeModeComboBox.addItem(getString("TableDemo.subsequent_columns"));
        resizeModeComboBox.addItem(getString("TableDemo.last_column"));
        resizeModeComboBox.addItem(getString("TableDemo.all_columns"));
        resizeModeComboBox.setSelectedIndex(tableView.getAutoResizeMode());
        resizeModeComboBox.addItemListener(new ItemListener() {
	    public void itemStateChanged(ItemEvent e) {
	        JComboBox source = (JComboBox)e.getSource();
                tableView.setAutoResizeMode(source.getSelectedIndex());
	    }
        });

        resizeMode.add(Box.createHorizontalStrut(2));
	resizeMode.add(resizeModeComboBox);
        resizeMode.add(Box.createHorizontalGlue());
        comboPanel.add(resizeMode);

        // print panel
        printPanel.setBorder(new TitledBorder(getString("TableDemo.printing")));
        headerLabel = new JLabel(getString("TableDemo.header"));
        footerLabel = new JLabel(getString("TableDemo.footer"));
        headerTextField = new JTextField(getString("TableDemo.headerText"), 15);
        footerTextField = new JTextField(getString("TableDemo.footerText"), 15);
        fitWidth = new JCheckBox(getString("TableDemo.fitWidth"), true);
        printButton = new JButton(getString("TableDemo.print"));
        printButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                printTable();
            }
        });

        printPanel.add(headerLabel);
        printPanel.add(headerTextField);
        printPanel.add(footerLabel);
        printPanel.add(footerTextField);
        
        JPanel buttons = new JPanel();
        buttons.add(fitWidth);
        buttons.add(printButton);

        printPanel.add(buttons);

        // Show that printing controls are related
        relatedComponents.removeAllElements();
        relatedComponents.add(headerTextField);
        relatedComponents.add(footerTextField);
        relatedComponents.add(printButton);
        buildAccessibleGroup(relatedComponents);

        // wrap up the panels and add them
        JPanel sliderWrapper = new JPanel();
        sliderWrapper.setLayout(new BoxLayout(sliderWrapper, BoxLayout.X_AXIS));
        sliderWrapper.add(labelPanel);
        sliderWrapper.add(sliderPanel);
        sliderWrapper.add(Box.createHorizontalGlue());
        sliderWrapper.setBorder(BorderFactory.createEmptyBorder(0, 4, 0, 0));
        
        JPanel leftWrapper = new JPanel();
        leftWrapper.setLayout(new BoxLayout(leftWrapper, BoxLayout.Y_AXIS));
        leftWrapper.add(cbPanel);
        leftWrapper.add(sliderWrapper);

        // add everything
        controlPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 2, 0));
        controlPanel.add(leftWrapper);
        controlPanel.add(comboPanel);
        controlPanel.add(printPanel);

	setTableControllers(); // Set accessibility information
    } // TableDemo()

    /**
     * Sets the Accessibility MEMBER_OF property to denote that
     * these components work together as a group. Each object 
     * is set to be a MEMBER_OF an array that contains all of
     * the objects in the group, including itself.
     *
     * @param components The list of objects that are related
     */
    void buildAccessibleGroup(Vector components) {

	AccessibleContext context = null;
	int numComponents = components.size();
	Object[] group = components.toArray();
	Object object = null;
	for (int i = 0; i < numComponents; ++i) {
	    object = components.elementAt(i);
	    if (object instanceof Accessible) {
	        context = ((Accessible)components.elementAt(i)).
						 getAccessibleContext();
		context.getAccessibleRelationSet().add(
		    new AccessibleRelation(
			AccessibleRelation.MEMBER_OF, group));
	    }
	}
    } // buildAccessibleGroup()

    /**
     * This sets CONTROLLER_FOR on the controls that manipulate the
     * table and CONTROLLED_BY relationships on the table to point
     * back to the controllers.
     */
    private void setTableControllers() {

	// Set up the relationships to show what controls the table
	setAccessibleController(isColumnReorderingAllowedCheckBox, 
				tableAggregate);
	setAccessibleController(showHorizontalLinesCheckBox,
				tableAggregate);
	setAccessibleController(showVerticalLinesCheckBox,
				tableAggregate);
	setAccessibleController(isColumnSelectionAllowedCheckBox,
				tableAggregate);
	setAccessibleController(isRowSelectionAllowedCheckBox,
				tableAggregate);
	setAccessibleController(interCellSpacingSlider,
				tableAggregate);
	setAccessibleController(rowHeightSlider,
				tableAggregate);
	setAccessibleController(selectionModeComboBox,
				tableAggregate);
	setAccessibleController(resizeModeComboBox,
				tableAggregate);
    } // setTableControllers()

    /**
     * Sets up accessibility relationships to denote that one 
     * object controls another. The CONTROLLER_FOR property is
     * set on the controller object, and the CONTROLLED_BY
     * property is set on the target object.
     */
    private void setAccessibleController(JComponent controller,
					JComponent target) {
	AccessibleRelationSet controllerRelations = 
	    controller.getAccessibleContext().getAccessibleRelationSet();
	AccessibleRelationSet targetRelations = 
	    target.getAccessibleContext().getAccessibleRelationSet();

	controllerRelations.add(
	    new AccessibleRelation(
		AccessibleRelation.CONTROLLER_FOR, target));
	targetRelations.add(
	    new AccessibleRelation(
		AccessibleRelation.CONTROLLED_BY, controller));
    } // setAccessibleController()

    public JScrollPane createTable() {

        // final
        final String[] names = {
	  getString("TableDemo.first_name"),
	  getString("TableDemo.last_name"),
	  getString("TableDemo.favorite_color"),
	  getString("TableDemo.favorite_movie"),
	  getString("TableDemo.favorite_number"),
	  getString("TableDemo.favorite_food")
	};

	ImageIcon apple        = createImageIcon("ImageClub/food/apple.jpg",      getString("TableDemo.apple"));
	ImageIcon asparagus    = createImageIcon("ImageClub/food/asparagus.jpg",  getString("TableDemo.asparagus"));
	ImageIcon banana       = createImageIcon("ImageClub/food/banana.jpg",     getString("TableDemo.banana"));
	ImageIcon broccoli     = createImageIcon("ImageClub/food/broccoli.jpg",   getString("TableDemo.broccoli"));
	ImageIcon cantaloupe   = createImageIcon("ImageClub/food/cantaloupe.jpg", getString("TableDemo.cantaloupe"));
	ImageIcon carrot       = createImageIcon("ImageClub/food/carrot.jpg",     getString("TableDemo.carrot"));
	ImageIcon corn         = createImageIcon("ImageClub/food/corn.jpg",       getString("TableDemo.corn"));
	ImageIcon grapes       = createImageIcon("ImageClub/food/grapes.jpg",     getString("TableDemo.grapes"));
	ImageIcon grapefruit   = createImageIcon("ImageClub/food/grapefruit.jpg", getString("TableDemo.grapefruit"));
	ImageIcon kiwi         = createImageIcon("ImageClub/food/kiwi.jpg",       getString("TableDemo.kiwi"));
	ImageIcon onion        = createImageIcon("ImageClub/food/onion.jpg",      getString("TableDemo.onion"));
	ImageIcon pear         = createImageIcon("ImageClub/food/pear.jpg",       getString("TableDemo.pear"));
	ImageIcon peach        = createImageIcon("ImageClub/food/peach.jpg",      getString("TableDemo.peach"));
	ImageIcon pepper       = createImageIcon("ImageClub/food/pepper.jpg",     getString("TableDemo.pepper"));
	ImageIcon pickle       = createImageIcon("ImageClub/food/pickle.jpg",     getString("TableDemo.pickle"));
	ImageIcon pineapple    = createImageIcon("ImageClub/food/pineapple.jpg",  getString("TableDemo.pineapple"));
	ImageIcon raspberry    = createImageIcon("ImageClub/food/raspberry.jpg",  getString("TableDemo.raspberry"));
	ImageIcon sparegrass   = createImageIcon("ImageClub/food/asparagus.jpg",  getString("TableDemo.sparegrass"));
	ImageIcon strawberry   = createImageIcon("ImageClub/food/strawberry.jpg", getString("TableDemo.strawberry"));
	ImageIcon tomato       = createImageIcon("ImageClub/food/tomato.jpg",     getString("TableDemo.tomato"));
	ImageIcon watermelon   = createImageIcon("ImageClub/food/watermelon.jpg", getString("TableDemo.watermelon"));

	NamedColor aqua        = new NamedColor(new Color(127, 255, 212), getString("TableDemo.aqua"));
	NamedColor beige       = new NamedColor(new Color(245, 245, 220), getString("TableDemo.beige"));
	NamedColor black       = new NamedColor(Color.black, getString("TableDemo.black"));
	NamedColor blue        = new NamedColor(new Color(0, 0, 222), getString("TableDemo.blue"));
	NamedColor eblue       = new NamedColor(Color.blue, getString("TableDemo.eblue"));
	NamedColor jfcblue     = new NamedColor(new Color(204, 204, 255), getString("TableDemo.jfcblue"));
	NamedColor jfcblue2    = new NamedColor(new Color(153, 153, 204), getString("TableDemo.jfcblue2"));
	NamedColor cybergreen  = new NamedColor(Color.green.darker().brighter(), getString("TableDemo.cybergreen"));
	NamedColor darkgreen   = new NamedColor(new Color(0, 100, 75), getString("TableDemo.darkgreen"));
	NamedColor forestgreen = new NamedColor(Color.green.darker(), getString("TableDemo.forestgreen"));
	NamedColor gray        = new NamedColor(Color.gray, getString("TableDemo.gray"));
	NamedColor green       = new NamedColor(Color.green, getString("TableDemo.green"));
	NamedColor orange      = new NamedColor(new Color(255, 165, 0), getString("TableDemo.orange"));
	NamedColor purple      = new NamedColor(new Color(160, 32, 240),  getString("TableDemo.purple"));
	NamedColor red         = new NamedColor(Color.red, getString("TableDemo.red"));
	NamedColor rustred     = new NamedColor(Color.red.darker(), getString("TableDemo.rustred"));
	NamedColor sunpurple   = new NamedColor(new Color(100, 100, 255), getString("TableDemo.sunpurple"));
	NamedColor suspectpink = new NamedColor(new Color(255, 105, 180), getString("TableDemo.suspectpink"));
	NamedColor turquoise   = new NamedColor(new Color(0, 255, 255), getString("TableDemo.turquoise"));
	NamedColor violet      = new NamedColor(new Color(238, 130, 238), getString("TableDemo.violet"));
	NamedColor yellow      = new NamedColor(Color.yellow, getString("TableDemo.yellow"));

        // Create the dummy data (a few rows of names)
        final Object[][] data = {
	  {"Mike", "Albers",      green,       getString("TableDemo.brazil"), new Double(44.0), strawberry},
	  {"Mark", "Andrews",     blue,        getString("TableDemo.curse"), new Double(3), grapes},
	  {"Brian", "Beck",       black,       getString("TableDemo.bluesbros"), new Double(2.7182818285), raspberry},
	  {"Lara", "Bunni",       red,         getString("TableDemo.airplane"), new Double(15), strawberry},
	  {"Roger", "Brinkley",   blue,        getString("TableDemo.man"), new Double(13), peach},
	  {"Brent", "Christian",  black,       getString("TableDemo.bladerunner"), new Double(23), broccoli},
	  {"Mark", "Davidson",    darkgreen,   getString("TableDemo.brazil"), new Double(27), asparagus},
	  {"Jeff", "Dinkins",     blue,        getString("TableDemo.ladyvanishes"), new Double(8), kiwi},
	  {"Ewan", "Dinkins",     yellow,      getString("TableDemo.bugs"), new Double(2), strawberry},
	  {"Amy", "Fowler",       violet,      getString("TableDemo.reservoir"), new Double(3), raspberry},
	  {"Hania", "Gajewska",   purple,      getString("TableDemo.jules"), new Double(5), raspberry},
	  {"David", "Geary",      blue,        getString("TableDemo.pulpfiction"), new Double(3), watermelon},
//	  {"James", "Gosling",    pink,        getString("TableDemo.tennis"), new Double(21), donut},
	  {"Eric", "Hawkes",      blue,        getString("TableDemo.bladerunner"), new Double(.693), pickle},
          {"Shannon", "Hickey",   green,       getString("TableDemo.shawshank"), new Integer(2), grapes},
	  {"Earl", "Johnson",     green,       getString("TableDemo.pulpfiction"), new Double(8), carrot},
	  {"Robi", "Khan",        green,       getString("TableDemo.goodfellas"), new Double(89), apple},
	  {"Robert", "Kim",       blue,        getString("TableDemo.mohicans"), new Double(655321), strawberry},
	  {"Janet", "Koenig",     turquoise,   getString("TableDemo.lonestar"), new Double(7), peach},
	  {"Jeff", "Kesselman",   blue,        getString("TableDemo.stuntman"), new Double(17), pineapple},
	  {"Onno", "Kluyt",       orange,      getString("TableDemo.oncewest"), new Double(8), broccoli},
	  {"Peter", "Korn",       sunpurple,   getString("TableDemo.musicman"), new Double(12), sparegrass},

	  {"Rick", "Levenson",    black,       getString("TableDemo.harold"), new Double(1327), raspberry},
	  {"Brian", "Lichtenwalter", jfcblue,  getString("TableDemo.fifthelement"), new Double(22), pear},
	  {"Malini", "Minasandram", beige,     getString("TableDemo.joyluck"), new Double(9), corn},
	  {"Michael", "Martak",   green,       getString("TableDemo.city"), new Double(3), strawberry},
	  {"David", "Mendenhall", forestgreen, getString("TableDemo.schindlerslist"), new Double(7), peach},
	  {"Phil", "Milne",       suspectpink, getString("TableDemo.withnail"), new Double(3), banana},
	  {"Lynn", "Monsanto",    cybergreen,  getString("TableDemo.dasboot"), new Double(52), peach},
	  {"Hans", "Muller",      rustred,     getString("TableDemo.eraserhead"), new Double(0), pineapple},
          {"Joshua", "Outwater",  blue,        getString("TableDemo.labyrinth"), new Integer(3), pineapple},
	  {"Tim", "Prinzing",     blue,        getString("TableDemo.firstsight"), new Double(69), pepper},
	  {"Raj", "Premkumar",    jfcblue2,    getString("TableDemo.none"), new Double(7), broccoli},
	  {"Howard", "Rosen",     green,       getString("TableDemo.defending"), new Double(7), strawberry},
	  {"Ray", "Ryan",         black,       getString("TableDemo.buckaroo"),
	   new Double(3.141592653589793238462643383279502884197169399375105820974944), banana},
	  {"Georges", "Saab",     aqua,        getString("TableDemo.bicycle"), new Double(290), cantaloupe},
	  {"Tom", "Santos",       blue,        getString("TableDemo.spinaltap"), new Double(241), pepper},
	  {"Rich", "Schiavi",     blue,        getString("TableDemo.repoman"), new Double(0xFF), pepper},
	  {"Nancy", "Schorr",     green,       getString("TableDemo.fifthelement"), new Double(47), watermelon},
	  {"Keith", "Sprochi",    darkgreen,   getString("TableDemo.2001"), new Integer(13), watermelon},
	  {"Matt", "Tucker",      eblue,       getString("TableDemo.starwars"), new Integer(2), broccoli},
	  {"Dmitri", "Trembovetski", red,      getString("TableDemo.aliens"), new Integer(222), tomato},
	  {"Scott", "Violet",     violet,      getString("TableDemo.raiders"), new Integer(-97), banana},
	  {"Kathy", "Walrath",    blue,        getString("TableDemo.thinman"), new Integer(8), pear},
	  {"Nathan", "Walrath",   black,       getString("TableDemo.chusingura"), new Integer(3), grapefruit},
	  {"Steve", "Wilson",     green,       getString("TableDemo.raiders"), new Integer(7), onion},
	  {"Kathleen", "Zelony",  gray,        getString("TableDemo.dog"), new Integer(13), grapes}
        };

        // Create a model of the data.
        TableModel dataModel = new AbstractTableModel() {
            public int getColumnCount() { return names.length; }
            public int getRowCount() { return data.length;}
            public Object getValueAt(int row, int col) {return data[row][col];}
            public String getColumnName(int column) {return names[column];}
            public Class getColumnClass(int c) {return getValueAt(0, c).getClass();}
	    public boolean isCellEditable(int row, int col) {return col != 5;}
            public void setValueAt(Object aValue, int row, int column) { data[row][column] = aValue; }
         };


        // Create the table
        tableView = new JTable(dataModel);

        // Show colors by rendering them in their own color.
        DefaultTableCellRenderer colorRenderer = new DefaultTableCellRenderer() {
	    public void setValue(Object value) {
	        if (value instanceof NamedColor) {
		    NamedColor c = (NamedColor) value;
	            setBackground(c);
	            setForeground(c.getTextColor());
	            setText(c.toString());
		} else {
		    super.setValue(value);
		}
	    }
        };

	// Create a combo box to show that you can use one in a table.
        JComboBox comboBox = new JComboBox();
	comboBox.addItem(aqua);
	comboBox.addItem(beige);
	comboBox.addItem(black);
	comboBox.addItem(blue);
	comboBox.addItem(eblue);
	comboBox.addItem(jfcblue);
	comboBox.addItem(jfcblue2);
	comboBox.addItem(cybergreen);
	comboBox.addItem(darkgreen);
	comboBox.addItem(forestgreen);
	comboBox.addItem(gray);
	comboBox.addItem(green);
	comboBox.addItem(orange);
	comboBox.addItem(purple);
	comboBox.addItem(red);
	comboBox.addItem(rustred);
	comboBox.addItem(sunpurple);
	comboBox.addItem(suspectpink);
	comboBox.addItem(turquoise);
	comboBox.addItem(violet);
	comboBox.addItem(yellow);

        TableColumn colorColumn = tableView.getColumn(getString("TableDemo.favorite_color"));
        // Use the combo box as the editor in the "Favorite Color" column.
        colorColumn.setCellEditor(new DefaultCellEditor(comboBox));

        colorRenderer.setHorizontalAlignment(JLabel.CENTER);
        colorColumn.setCellRenderer(colorRenderer);

        tableView.setRowHeight(INITIAL_ROWHEIGHT);

        scrollpane = new JScrollPane(tableView);
        return scrollpane;
    }

    private void printTable() {
        MessageFormat headerFmt;
        MessageFormat footerFmt;
        JTable.PrintMode printMode = fitWidth.isSelected() ?
                                     JTable.PrintMode.FIT_WIDTH :
                                     JTable.PrintMode.NORMAL;

        String text;
        text = headerTextField.getText();
        if (text != null && text.length() > 0) {
            headerFmt = new MessageFormat(text);
        } else {
            headerFmt = null;
        }

        text = footerTextField.getText();
        if (text != null && text.length() > 0) {
            footerFmt = new MessageFormat(text);
        } else {
            footerFmt = null;
        }

        try {
            boolean status = tableView.print(printMode, headerFmt, footerFmt);

            if (status) {
                JOptionPane.showMessageDialog(this, getString("TableDemo.printingComplete"),
                                                    getString("TableDemo.printingResult"),
                                                    JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, getString("TableDemo.printingCancelled"),
                                                    getString("TableDemo.printingResult"),
                                                    JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (PrinterException pe) {
            String errorMessage = MessageFormat.format(getString("TableDemo.printingFailed"),
                                                       new Object[] {pe.getMessage()});
            JOptionPane.showMessageDialog(this, errorMessage,
                                                getString("TableDemo.printingResult"),
                                                JOptionPane.ERROR_MESSAGE);
        }
    }

    class NamedColor extends Color {
	String name;
	public NamedColor(Color color, String name) {
	    super(color.getRGB());
	    this.name = name;
	}
	
	public Color getTextColor() {
	    int r = getRed();
	    int g = getGreen();
	    int b = getBlue();
	    if(r > 240 || g > 240) {
		return Color.black;
	    } else {
		return Color.white;
	    }
	}
	
	public String toString() {
	    return name;
	}
    }
    
    class ColumnLayout implements LayoutManager {
	int xInset = 5;
	int yInset = 5;
	int yGap = 2;
	
	public void addLayoutComponent(String s, Component c) {}
	
	public void layoutContainer(Container c) {
	    Insets insets = c.getInsets();
	    int height = yInset + insets.top;
	    
	    Component[] children = c.getComponents();
	    Dimension compSize = null;
	    for (int i = 0; i < children.length; i++) {
		compSize = children[i].getPreferredSize();
		children[i].setSize(compSize.width, compSize.height);
		children[i].setLocation( xInset + insets.left, height);
		height += compSize.height + yGap;
	    }
	    
	}
	
	public Dimension minimumLayoutSize(Container c) {
	    Insets insets = c.getInsets();
	    int height = yInset + insets.top;
	    int width = 0 + insets.left + insets.right;
	    
	    Component[] children = c.getComponents();
	    Dimension compSize = null;
	    for (int i = 0; i < children.length; i++) {
		compSize = children[i].getPreferredSize();
		height += compSize.height + yGap;
		width = Math.max(width, compSize.width + insets.left + insets.right + xInset*2);
	    }
	    height += insets.bottom;
	    return new Dimension( width, height);
	}
	
	public Dimension preferredLayoutSize(Container c) {
	    return minimumLayoutSize(c);
	}
	
	public void removeLayoutComponent(Component c) {}
    }
    
    void updateDragEnabled(boolean dragEnabled) {
        tableView.setDragEnabled(dragEnabled);
        headerTextField.setDragEnabled(dragEnabled);
        footerTextField.setDragEnabled(dragEnabled);
    }

}
