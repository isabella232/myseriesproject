/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * AdminEpisodes.java
 *
 * Created on 7 Νοε 2008, 5:37:48 μμ
 */
package myseries.episodes;

import com.googlecode.svalidators.formcomponents.ValidationGroup;
import com.googlecode.svalidators.validators.RequiredValidator;
import database.DBHelper;
import java.io.IOException;
import java.text.ParseException;
import myseries.*;
import myComponents.MyUsefulFunctions;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import database.EpisodesRecord;
import database.SeriesRecord;
import java.util.Calendar;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import myComponents.MyMessages;
import myComponents.myGUI.MyDraggable;
import tools.download.subtitles.Subtitle;
import tools.languages.LangsList;
import tools.languages.Language;
import tools.options.Options;

/**
 * The admin episodes panel
 * @author lordovol
 */
public class AdminEpisodes extends MyDraggable {

  public static final long serialVersionUID = 243564578251L;
  /**
   * The main form of MySeries
   */
  private MySeries m;
  /**
   * The series record of the episode to admin
   */
  private SeriesRecord seriesRecord;
  /**
   * The episode to edmin record
   */
  private EpisodesRecord episodeRecord;
  /**
   * The episodes number
   */
  private int episodeNo;

  /**
   * Administrate an episodes record
   * @param m Myseries main form
   * @param currentSerial The current series of the episode to admin
   * @param currentEpisode The episode to admin
   * @throws java.sql.SQLException
   * @throws java.io.IOException
   */
  public AdminEpisodes(MySeries m, SeriesRecord currentSerial, EpisodesRecord currentEpisode) throws SQLException, IOException {
    this.m = m;
    this.seriesRecord = currentSerial;
    this.episodeRecord = currentEpisode;
    initComponents();
    combobox_subtitles.setModel(new DefaultComboBoxModel(new Language[]{
    LangsList.NONE,
    myseries.MySeries.languages.getPrimary(),
    myseries.MySeries.languages.getSecondary(),
    LangsList.MULTIPLE
    }));
    setLocationRelativeTo(m);
    label_title.setText("Add Episode to " + seriesRecord.getTitle()
            + " S" + MyUsefulFunctions.padLeft(seriesRecord.getSeason(), 2, "0"));
    getLatestEpisode();
    spinner_episode.setValue(episodeNo);
    setVisible(true);
  }

  /**
   * Gets the latest episode of the series and sets the spinner to the next number
   * @throws java.sql.SQLException
   * @throws java.io.IOException
   */
  private void getLatestEpisode() throws SQLException, IOException {
    MySeries.logger.log(Level.INFO, "Get the latest episode");
    Vector<EpisodesRecord> episodes = DBHelper.getEpisodesBySql(
            "select * from episodes where series_ID = "
            + seriesRecord.getSeries_ID() + " order by CAST(episode AS INT) desc limit 1");
    if (episodes.size() > 0) {
      episodeNo = episodes.get(0).getEpisode() + 1;
    } else {
      episodeNo = 1;
    }
  }

  /** This method is called from within the constructor to
   * initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is
   * always regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jPanel1 = new javax.swing.JPanel();
    button_Add = new javax.swing.JButton();
    button_Cancel = new javax.swing.JButton();
    label_title = new javax.swing.JLabel();
    jPanel2 = new javax.swing.JPanel();
    dateChooser = new com.toedter.calendar.JDateChooser();
    checkbox_seen = new javax.swing.JCheckBox();
    label_EpisodeTitle = new javax.swing.JLabel();
    label_subtitles = new javax.swing.JLabel();
    label_EpisodeNumber = new javax.swing.JLabel();
    combobox_subtitles = new javax.swing.JComboBox();
    textfield_title = new com.googlecode.svalidators.formcomponents.STextField(new RequiredValidator());
    checkbox_downloaded = new javax.swing.JCheckBox();
    label_Date = new javax.swing.JLabel();
    spinner_episode = new javax.swing.JSpinner();

    setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
    setResizable(false);

    jPanel1.setBackground(new java.awt.Color(255, 255, 255));
    jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
    jPanel1.setOpaque(false);
    jPanel1.setPreferredSize(new java.awt.Dimension(500, 229));

    button_Add.setText("Add");
    button_Add.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        button_AddActionPerformed(evt);
      }
    });

    button_Cancel.setText("Cancel");
    button_Cancel.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        button_CancelActionPerformed(evt);
      }
    });

    label_title.setFont(label_title.getFont().deriveFont(label_title.getFont().getStyle() | java.awt.Font.BOLD, label_title.getFont().getSize()+2));
    label_title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

    jPanel2.setOpaque(false);

    dateChooser.setDateFormatString(Options.toString(Options.DATE_FORMAT));
    dateChooser.setOpaque(false);

    checkbox_seen.setText("Seen");
    checkbox_seen.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
    checkbox_seen.setOpaque(false);

    label_EpisodeTitle.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    label_EpisodeTitle.setText("Title:");

    label_subtitles.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    label_subtitles.setText("Subtitles:");
    label_subtitles.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

    label_EpisodeNumber.setText("Episode:");

    textfield_title.setName("Title"); // NOI18N
    textfield_title.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyReleased(java.awt.event.KeyEvent evt) {
        textfield_titleKeyReleased(evt);
      }
    });

    checkbox_downloaded.setText("Downloaded");
    checkbox_downloaded.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
    checkbox_downloaded.setOpaque(false);

    label_Date.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    label_Date.setText("Date:");

    spinner_episode.setModel(new javax.swing.SpinnerNumberModel(1, 0, 99, 1));
    spinner_episode.setEditor(new javax.swing.JSpinner.NumberEditor(spinner_episode, ""));
    spinner_episode.setValue(episodeNo);

    javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel2Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
          .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
            .addComponent(label_EpisodeTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(label_Date, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addComponent(label_subtitles, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(label_EpisodeNumber))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addComponent(textfield_title, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
          .addGroup(jPanel2Layout.createSequentialGroup()
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(dateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(combobox_subtitles, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
              .addComponent(checkbox_downloaded)
              .addComponent(checkbox_seen)))
          .addComponent(spinner_episode, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addContainerGap(66, Short.MAX_VALUE))
    );
    jPanel2Layout.setVerticalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(spinner_episode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(label_EpisodeNumber))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(label_EpisodeTitle)
          .addComponent(textfield_title, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
          .addComponent(dateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(checkbox_downloaded)
          .addComponent(label_Date))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(combobox_subtitles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(label_subtitles)
          .addComponent(checkbox_seen))
        .addContainerGap())
    );

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addGap(25, 25, 25)
        .addComponent(button_Add, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(button_Cancel)
        .addContainerGap(349, Short.MAX_VALUE))
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
          .addComponent(label_title, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE)
          .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addGap(26, 26, 26))
    );
    jPanel1Layout.setVerticalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(label_title, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(18, 18, 18)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(button_Cancel)
          .addComponent(button_Add))
        .addContainerGap(23, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 512, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
    );

    java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
    setBounds((screenSize.width-528)/2, (screenSize.height-261)/2, 528, 261);
  }// </editor-fold>//GEN-END:initComponents

    private void button_AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_AddActionPerformed
      try {
        ValidationGroup group = new ValidationGroup();
        group.addComponent(textfield_title);
        if(group.validate()){
        addTheEpisode();
        } else {
          group.errorMessage(true);
        }
      } catch (IOException ex) {
        MySeries.logger.log(Level.SEVERE, null, ex);
      } catch (ParseException ex) {
        Logger.getLogger(AdminEpisodes.class.getName()).log(Level.SEVERE, null, ex);
      }
}//GEN-LAST:event_button_AddActionPerformed

  /**
   * Adds the episode to the Database
   * @throws java.io.IOException
   */
  private void addTheEpisode() throws IOException, ParseException {
    if (episodeRecord == null) {
      episodeRecord = new EpisodesRecord();
    }
    episodeRecord.setSeries_ID(seriesRecord.getSeries_ID());
    episodeRecord.setTitle(textfield_title.getText().trim());
    try {
      episodeRecord.setEpisode(Integer.parseInt(spinner_episode.getValue().toString()));
    } catch (NumberFormatException ex) {
      MySeries.logger.log(Level.WARNING, "Episode must be an integer");
      MyMessages.error("Not an integer", "Episode must be an integer");
      return;
    }
    if (textfield_title.getText().trim().equals("")) {
      MySeries.logger.log(Level.WARNING, "Episode title must not be blank");
      MyMessages.error("No Title!!!", "The episode title must not be blank");
      return;
    }
    episodeRecord.setSubs((Language) combobox_subtitles.getSelectedItem());
    episodeRecord.setSeen(checkbox_seen.isSelected() ? 1 : 0);
    episodeRecord.setDownloaded(checkbox_downloaded.isSelected() ? 1 : 0);
    SimpleDateFormat f = new SimpleDateFormat(EpisodesRecord.MYSQL_DATE_FORMAT);
    String aired;
    try {
      MySeries.logger.log(Level.INFO, "Adding episode " + episodeRecord.getTitle());
      if (dateChooser.getDate() == null) {
        aired = f.format(Calendar.getInstance().getTime());
      } else {
        aired = f.format(dateChooser.getDate());
      }
      episodeRecord.setAired(aired);
      episodeRecord.save();
      Episodes.getCurrentSeriesEpisodes();
      dispose();
      MySeries.glassPane.deactivate();
      MySeries.logger.log(Level.INFO, "Episode added");
    } catch (SQLException ex) {
      MySeries.logger.log(Level.SEVERE, "There was an error while writting the episode to the database", ex);
      MyMessages.error("SQL Error!!!", "There was an error while writting the episode to the database");
    } catch (NullPointerException ex) {
      MySeries.logger.log(Level.WARNING, "The date is not in the right format");
      MyMessages.error("Date Error!!!", "The date is not in the right format");
    }
  }

    private void button_CancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_CancelActionPerformed
      dispose();
      MySeries.glassPane.deactivate();
}//GEN-LAST:event_button_CancelActionPerformed

    private void textfield_titleKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textfield_titleKeyReleased
      textfield_title.validateValue();
    }//GEN-LAST:event_textfield_titleKeyReleased
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton button_Add;
  private javax.swing.JButton button_Cancel;
  private javax.swing.JCheckBox checkbox_downloaded;
  private javax.swing.JCheckBox checkbox_seen;
  private javax.swing.JComboBox combobox_subtitles;
  private com.toedter.calendar.JDateChooser dateChooser;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JPanel jPanel2;
  private javax.swing.JLabel label_Date;
  private javax.swing.JLabel label_EpisodeNumber;
  private javax.swing.JLabel label_EpisodeTitle;
  private javax.swing.JLabel label_subtitles;
  private javax.swing.JLabel label_title;
  private javax.swing.JSpinner spinner_episode;
  private com.googlecode.svalidators.formcomponents.STextField textfield_title;
  // End of variables declaration//GEN-END:variables
}
