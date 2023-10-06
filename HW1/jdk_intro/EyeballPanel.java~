import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

/**
 * Eyeballs.java
 * Adapted from the original Eyeballs.java Copyright(C)1996. Masakazu Fujimiya fujimiya@nri.co.jp
 * @author Robert Cohen
 */

public class EyeballPanel
    extends JPanel {
  private int numEyes, eyeSize;
  private int mousex, mousey;
  private Eye[] eyes;

  /**
   * Default constructor
   */
  public EyeballPanel() {
    this(20, 32);
  }

  /**
   * Constructs a panel with roving eyeballs
   */
  public EyeballPanel(int num, int eyeSize) {
    this.numEyes = num;
    this.eyeSize = eyeSize;
    eyes = new Eye[numEyes];

    this.addMouseMotionListener(new MouseMotionAdapter() {
      public void mouseMoved(MouseEvent e) {
        mousex = e.getX();
        mousey = e.getY();
        repaint();
      }
    });

    this.addComponentListener(new ComponentAdapter() {
      public void componentResized(ComponentEvent e) {
        initEyes();
        repaint();
      }
    });
  }

  /**
   * Draw all eyeballs
   */
  public void paint(Graphics g) {
    super.paint(g);
    if (eyes != null && eyes[0] != null)  // eliminate race condition
      for (Eye e : eyes) {
        e.draw(g, mousex, mousey);
    }
  }

  /**
   * Build the eye objects.  Each eye is placed in a random grid position.
   */
  private void initEyes() {
    int panelWidth = this.getWidth();
    int panelHeight = this.getHeight();
    if ( (panelWidth <= 0) || (panelHeight <= 0)) {
      return;
    }
    Random rand = new Random();
    int width = this.getWidth() / eyeSize;
    int height = this.getHeight() / eyeSize;
    for (int i = 0; i < numEyes; i++) {
      eyes[i] = new Eye(rand.nextInt(width), rand.nextInt(height), eyeSize);
    }
  }

  /**
   * Tests the panel by running it in a JFrame
   */
  public static void main(String[] args) {
    JFrame f = new JFrame("The eyes have it!");
    f.getContentPane().add(new EyeballPanel());
    f.setSize(400, 300);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setVisible(true);
  }
}
