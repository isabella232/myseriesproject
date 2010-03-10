/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package myComponents;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import tools.options.Options;

/**
 *
 * @author ssoldatos
 */
public class ImagePanel extends JPanel {
  private static final long serialVersionUID = 356475743574387L;
  private Image image;

  public ImagePanel() {
    this.image = new ImageIcon(getClass().getResource("/images/logo.png")).getImage();
    this.setBorder(BorderFactory.createLineBorder(Color.black));
  }

  public ImagePanel(Image image){
    this.image = image;
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.drawImage(getImage(), 0, 0, getWidth(),getHeight(), this);
  }

  /**
   * @return the image
   */
  public Image getImage() {
    return image;
  }

  /**
   * @param image the image to set
   */
  public void setImage(Image image) {
    this.image = image;
    repaint();
  }

  
}