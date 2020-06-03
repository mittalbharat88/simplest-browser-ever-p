import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.HyperlinkListener;
import javax.swing.event.HyperlinkEvent;

public class Browser extends JFrame{
    private JTextField address;
    private JEditorPane display;

    Browser(){
        super("simple Browser");

        address = new JTextField("Enter the URL here!");
        address.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent event) {
                    loadAddress(event.getActionCommand());
                }
            }
        );
        add(address, BorderLayout.NORTH);

        display = new JEditorPane();
        display.setEditable(false);
        display.addHyperlinkListener(
                new HyperlinkListener() {
                    public void hyperlinkUpdate(HyperlinkEvent event) {
                        if(event.getEventType()== HyperlinkEvent.EventType.ACTIVATED){
                            loadAddress(event.getURL().toString());
                        }
                    }
                }
        );
        add(new JScrollPane(display) , BorderLayout.CENTER);

        setSize(600,400);
        setVisible(true);
    }

    private void loadAddress(String getUrl){
        try{
            display.setPage(getUrl);
            address.setText(getUrl);
        }catch(Exception e){
            System.out.println("please enter correct address! "+ e);
        }
    }

}