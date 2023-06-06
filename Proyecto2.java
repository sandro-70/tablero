import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class Proyecto2 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Tablero");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File("C:\\Users\\ferna\\Downloads\\Tablero.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(900, 900));

        
        ImageIcon imageIcon = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon);
        label.setBounds(0, 0, 900, 900);

        
        JPanel overlayPanel = new JPanel(new GridLayout(10, 10));
        overlayPanel.setOpaque(false);

        int buttonSize = Math.min(image.getWidth() / 10, image.getHeight() / 10);
        
        for (int i = 1; i <= 100; i++) {
            JButton button = new JButton(" ");
            button.setOpaque(false);
            button.setContentAreaFilled(false);
            button.setBorder(BorderFactory.createLineBorder(Color.BLUE));
            button.setPreferredSize(new Dimension(buttonSize, buttonSize));
            
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    
                    System.out.println("Button clicked");
                }
            });

            overlayPanel.add(button);
        }

        
        Dimension overlaySize = new Dimension(buttonSize * 10, buttonSize * 10);
        int x = (900 - overlaySize.width) / 2;
        int y = (900 - overlaySize.height) / 2;
        overlayPanel.setBounds(x, y, overlaySize.width, overlaySize.height);

        
        layeredPane.add(label, JLayeredPane.DEFAULT_LAYER);
        layeredPane.add(overlayPanel, JLayeredPane.PALETTE_LAYER);

        
        frame.getContentPane().add(layeredPane);

        
        frame.setSize(900, 900);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
    }
}




