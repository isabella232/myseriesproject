/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * IsohuntForm.java
 *
 * Created on 2 Ιουν 2010, 6:34:04 μμ
 */
package tools.download.torrents.isohunt;

import com.googlecode.svalidators.formcomponents.SComboBox;
import com.googlecode.svalidators.formcomponents.ValidationGroup;
import com.googlecode.svalidators.validators.RequiredValidator;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.logging.Level;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import myComponents.MyMessages;
import myComponents.MyUsefulFunctions;
import tools.download.torrents.AbstractTorrentForm;
import tools.download.torrents.AbstractTorrent;

/**
 *
 * @author lordovol
 */
public class IsohuntForm extends AbstractTorrentForm {

  private static final long serialVersionUID = 235353163L;
  private ComboBoxModel sortModel;
  private ComboBoxModel sortOrderModel;

  {
    createModels();
  }

  @Override
  protected void createModels() {
    super.createModels();
    sortModel = new DefaultComboBoxModel(AbstractTorrent.SORT_OPTIONS);
    sortOrderModel = new DefaultComboBoxModel(AbstractTorrent.SORT_ORDER);

  }

  /** Creates new form IsohuntForm */
  public IsohuntForm() {
    initComponents();
    setLocationRelativeTo(null);
    setVisible(true);
  }

  /** This method is called from within the constructor to
   * initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is
   * always regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    panel = new javax.swing.JPanel();
    label_title = new javax.swing.JLabel();
    label_series = new javax.swing.JLabel();
    combo_series = new SComboBox(new RequiredValidator());
    jLabel3 = new javax.swing.JLabel();
    spinner_season = new javax.swing.JSpinner();
    jLabel4 = new javax.swing.JLabel();
    spinner_episode = new javax.swing.JSpinner();
    jLabel7 = new javax.swing.JLabel();
    combo_quality = new javax.swing.JComboBox();
    jLabel1 = new javax.swing.JLabel();
    jLabel2 = new javax.swing.JLabel();
    combo_sort = new javax.swing.JComboBox();
    combo_order = new javax.swing.JComboBox();
    button_search = new javax.swing.JButton();
    button_cancel = new javax.swing.JButton();
    progress = new javax.swing.JProgressBar();

    setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

    panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

    label_title.setFont(label_title.getFont().deriveFont(label_title.getFont().getStyle() | java.awt.Font.BOLD, label_title.getFont().getSize()+2));
    label_title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    label_title.setText("Download torrent from " + AbstractTorrent.ISOHUNT_NAME);

    label_series.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    label_series.setText("Series :");

    combo_series.setEditable(true);
    combo_series.setModel(seriesModel);
    combo_series.setName("Series title"); // NOI18N
    combo_series.setOpaque(false);
    combo_series.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        combo_seriesActionPerformed(evt);
      }
    });

    jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    jLabel3.setText("Season :");

    spinner_season.setModel(new javax.swing.SpinnerNumberModel(1, 1, 100, 1));

    jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    jLabel4.setText("Episode :");

    spinner_episode.setModel(new javax.swing.SpinnerNumberModel(1, 0, 100, 1));
    spinner_episode.addChangeListener(new javax.swing.event.ChangeListener() {
      public void stateChanged(javax.swing.event.ChangeEvent evt) {
        spinner_episodeStateChanged(evt);
      }
    });

    jLabel7.setText("0: Full season");

    combo_quality.setModel(qualityModel);

    jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    jLabel1.setText("Quality :");

    jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    jLabel2.setText("Sort :");

    combo_sort.setModel(sortModel);

    combo_order.setModel(sortOrderModel);

    button_search.setText("Search");
    button_search.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        button_searchActionPerformed(evt);
      }
    });

    button_cancel.setText("Cancel");
    button_cancel.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        button_cancelActionPerformed(evt);
      }
    });

    progress.setString("");
    progress.setStringPainted(true);

    javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
    panel.setLayout(panelLayout);
    panelLayout.setHorizontalGroup(
      panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(panelLayout.createSequentialGroup()
        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(panelLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(label_title, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE))
          .addGroup(panelLayout.createSequentialGroup()
            .addGap(12, 12, 12)
            .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(label_series, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
              .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
              .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
              .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
              .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
              .addComponent(combo_series, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(spinner_season, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addGroup(panelLayout.createSequentialGroup()
                .addComponent(spinner_episode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
              .addGroup(panelLayout.createSequentialGroup()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                  .addComponent(combo_sort, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                  .addComponent(combo_quality, javax.swing.GroupLayout.Alignment.LEADING, 0, 95, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(combo_order, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE))
          .addGroup(panelLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(button_search)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(button_cancel))
          .addGroup(panelLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(progress, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)))
        .addContainerGap())
    );
    panelLayout.setVerticalGroup(
      panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(panelLayout.createSequentialGroup()
        .addContainerGap()
        .addComponent(label_title)
        .addGap(18, 18, 18)
        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(label_series)
          .addComponent(combo_series, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel3)
          .addComponent(spinner_season, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel4)
          .addComponent(spinner_episode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabel7))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel1)
          .addComponent(combo_quality, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel2)
          .addComponent(combo_sort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(combo_order, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(18, 18, 18)
        .addComponent(progress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(button_search)
          .addComponent(button_cancel))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

    private void combo_seriesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_seriesActionPerformed
      combo_series.validateValue();
}//GEN-LAST:event_combo_seriesActionPerformed

    private void button_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_cancelActionPerformed
      dispose();
      myseries.MySeries.glassPane.deactivate();
    }//GEN-LAST:event_button_cancelActionPerformed

    private void button_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_searchActionPerformed
      ValidationGroup group = new ValidationGroup();
      group.addComponent(combo_series);
      if (group.validate()) {
        URI uri = createUri();
        if (uri != null) {
          Isohunt i = new Isohunt(uri, this);
          Thread t = new Thread(i);
          t.start();
        }
      } else {
        group.errorMessage(true);
      }
    }//GEN-LAST:event_button_searchActionPerformed

    private void spinner_episodeStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spinner_episodeStateChanged
      if (spinner_episode.getValue().toString().equals("0")) {
        combo_sort.setSelectedItem("Size");
        combo_order.setSelectedItem("Desc");
      } else {
        combo_sort.setSelectedIndex(0);
        combo_order.setSelectedIndex(0);
      }
    }//GEN-LAST:event_spinner_episodeStateChanged
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton button_cancel;
  private javax.swing.JButton button_search;
  private javax.swing.JComboBox combo_order;
  private javax.swing.JComboBox combo_quality;
  private com.googlecode.svalidators.formcomponents.SComboBox combo_series;
  private javax.swing.JComboBox combo_sort;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JLabel jLabel7;
  private javax.swing.JLabel label_series;
  private javax.swing.JLabel label_title;
  private javax.swing.JPanel panel;
  public javax.swing.JProgressBar progress;
  private javax.swing.JSpinner spinner_episode;
  private javax.swing.JSpinner spinner_season;
  // End of variables declaration//GEN-END:variables

  @Override
  protected URI createUri() {
    String address = AbstractTorrent.ISOHUNT_JSON;
    String query = "";
    ArrayList<String> q = new ArrayList<String>();
    String season = "+S" + MyUsefulFunctions.padLeft(String.valueOf(spinner_season.getValue()), 2, "0");
    String episode = String.valueOf(spinner_episode.getValue()).equals("0") ? "" : "E" + MyUsefulFunctions.padLeft(String.valueOf(spinner_episode.getValue()), 2, "0");
    try {
      q.add("ihq=" + URLEncoder.encode(
              String.valueOf(combo_series.getSelectedItem())
              + season + episode + "+"
              + String.valueOf(combo_quality.getSelectedItem()), "UTF-8"));
      q.add("sort=" + String.valueOf(combo_sort.getSelectedItem()).toLowerCase());
      q.add("order=" + String.valueOf(combo_order.getSelectedItem()).toLowerCase());
      q.add("iht=3");
      q.add("rows=20");
      query = MyUsefulFunctions.join(q, "&");
      return new URI(address + query);
    } catch (URISyntaxException ex) {
      MyMessages.error("Wrong url", "Wrong url " + address + query);
      myseries.MySeries.logger.log(Level.SEVERE, null, ex);
      return null;
    } catch (UnsupportedEncodingException ex) {
      myseries.MySeries.logger.log(Level.SEVERE, null, ex);
      return null;
    } catch (IOException ex) {
      myseries.MySeries.logger.log(Level.SEVERE, null, ex);
      return null;
    }
  }
}
