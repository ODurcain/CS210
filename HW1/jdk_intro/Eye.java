import java.awt.Color;
import java.awt.Graphics;

/**
 * Eyeballs.java
 * Adapted from the original Eyeballs.java Copyright(C)1996. Masakazu Fujimiya fujimiya@nri.co.jp
 * @author Robert Cohen
 */
class Eye {

  int rectx, recty, eyeSize;

  /**
   * Constructs a roving eyeball
   * @param x Grid position x
   * @param y Grid position y
   * @param eyeSize diameter of the eyeball
   */
  public Eye(int x, int y, int eyeSize) {
    this.eyeSize = eyeSize;
    rectx = x * eyeSize; // x value of eye rectangle left corner
    recty = y * eyeSize; // y value of eye rectangle top corner
  }

  /**
   * Draw the eyeball with pupil position based on mouse location.
   * @param g Graphics context to draw on
   * @param mousex Mouse X position
   * @param mousey Mouse Y position
   */
  public void draw(Graphics g, int mousex, int mousey) {
    double dist;
    int dx, dy, pupilX, pupilY;

    int centerX = rectx + eyeSize / 2; // center of eye
    int centerY = recty + eyeSize / 2;
    int pupilSize = eyeSize / 8 * 5;
    int gap = (eyeSize - pupilSize) / 2;

    dx = mousex - centerX;
    dy = mousey - centerY;
    dist = Math.sqrt(dx * dx + dy * dy);

    if (dist < gap) { // inside the pupil
      pupilX = mousex - pupilSize / 2 + 1;
      pupilY = mousey - pupilSize / 2 + 1;
    }
    else {
      double scale = gap / dist;
      pupilX = (int) (centerX + dx * scale - pupilSize / 2 + 1);
      pupilY = (int) (centerY + dy * scale - pupilSize / 2 + 1);
    }
    g.setColor(Color.white);
    g.fillOval(rectx, recty, eyeSize, eyeSize);
    g.setColor(Color.black);
    g.drawOval(rectx, recty, eyeSize, eyeSize);
    g.fillOval(pupilX, pupilY, pupilSize, pupilSize);

  }
}
