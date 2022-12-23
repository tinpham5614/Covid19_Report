import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

/**
 * Region Viewer Class extends from JFrame
 */
public class RegionViewer extends JFrame{
    private final RegionManager regionManager = new RegionManager();
    private int count = 0;

    /**
     * Region viewer Constructor
     * @throws FileNotFoundException if the file is not found
     */
    public RegionViewer() throws FileNotFoundException {
        //JFrame
        setTitle("COVID 19 - REPORT");
        setSize(700, 700);
        setResizable(false);
        Dimension screenSize = getToolkit().getScreenSize();
        setLocation((screenSize.width - getWidth()) / 2,
                (screenSize.height - getHeight()) / 2);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //JPanel
        JPanel panel = new JPanel();
        getContentPane().add(panel);
        panel.setLayout(null);

        //JLabel
        JLabel hintLabel = new JLabel("Click Load button to load data");
        hintLabel.setBounds(35,40, 200, 30);
        panel.add(hintLabel);

        JLabel regionLabel = new JLabel("Region:");
        regionLabel.setBounds(35, 150, 200, 30);
        panel.add(regionLabel);

        JLabel popLabel = new JLabel("Population:");
        popLabel.setBounds(35, 200, 200, 30);
        panel.add(popLabel);

        JLabel caseCountLabel = new JLabel("Case Count:");
        caseCountLabel.setBounds(35, 250, 200, 30);
        panel.add(caseCountLabel);

        JLabel hospCountLabel = new JLabel("Hospital Count:");
        hospCountLabel.setBounds(35, 300, 200, 30);
        panel.add(hospCountLabel);

        JLabel deathCountLabel = new JLabel("Death Count:");
        deathCountLabel.setBounds(35, 350, 200, 30);
        panel.add(deathCountLabel);

        JLabel totalHospIndLabel = new JLabel("Hospital Incidental Total:");
        totalHospIndLabel.setBounds(35, 400, 200, 30);
        panel.add(totalHospIndLabel);

        JLabel pcrTestCountLabel = new JLabel("PCR Test Count:");
        pcrTestCountLabel.setBounds(35, 450, 200, 30);
        panel.add(pcrTestCountLabel);

        JLabel pcrTestPosCountLabel = new JLabel("PCR Positive Count:");
        pcrTestPosCountLabel.setBounds(35, 500, 200, 30);
        panel.add(pcrTestPosCountLabel);

        JLabel pcrTestPosPercentLabel = new JLabel("PCR Positive Percent:");
        pcrTestPosPercentLabel.setBounds(35, 550, 200, 30);
        panel.add(pcrTestPosPercentLabel);

        //JTextField
        JTextField regionField = new JTextField();
        regionField.setBounds(200, 150, 300, 30);
        panel.add(regionField);

        JTextField popField = new JTextField();
        popField.setBounds(200, 200, 300, 30);
        panel.add(popField);

        JTextField caseCountField = new JTextField();
        caseCountField.setBounds(200, 250, 300, 30);
        panel.add(caseCountField);

        JTextField hospCountField = new JTextField();
        hospCountField.setBounds(200, 300, 300, 30);
        panel.add(hospCountField);

        JTextField deathCountField = new JTextField();
        deathCountField.setBounds(200, 350, 300, 30);
        panel.add(deathCountField);

        JTextField totalHospIndField = new JTextField();
        totalHospIndField.setBounds(200, 400, 300, 30);
        panel.add(totalHospIndField);

        JTextField pcrTestCountField = new JTextField();
        pcrTestCountField.setBounds(200, 450, 300, 30);
        panel.add(pcrTestCountField);

        JTextField pcrTestPosCountField = new JTextField();
        pcrTestPosCountField.setBounds(200, 500, 300, 30);
        panel.add(pcrTestPosCountField);

        JTextField pcrTestPosPercentField = new JTextField();
        pcrTestPosPercentField.setBounds(200, 550, 300, 30);
        panel.add(pcrTestPosPercentField);

        JButton loadButton = new JButton("Load Data");
        loadButton.setBounds(35, 80, 130, 30);
        panel.add(loadButton);
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                regionField.setText(regionManager.regionArrayList.get(count).geo_id());
                popField.setText(String.valueOf(regionManager.regionArrayList.get(count).pop()));
                caseCountField.setText(String.valueOf(regionManager.regionArrayList.get(count).case_count()));
                hospCountField.setText(String.valueOf(regionManager.regionArrayList.get(count).hosp_count()));
                deathCountField.setText(String.valueOf(regionManager.regionArrayList.get(count).death_count()));
                totalHospIndField.setText(String.valueOf(regionManager.regionArrayList.get(count).total_hosp_incidental()));
                pcrTestCountField.setText(String.valueOf(regionManager.regionArrayList.get(count).pcr_test_count()));
                pcrTestPosCountField.setText(String.valueOf(regionManager.regionArrayList.get(count).pcr_test_pos_count()));
                pcrTestPosPercentField.setText(String.valueOf(regionManager.regionArrayList.get(count).pcr_test_pos_percent()));
                hintLabel.setText("");
            }
        });

        JButton clearButton = new JButton("Clear");
        clearButton.setBounds(200, 80, 130, 30);
        panel.add(clearButton);
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                regionField.setText("");
                popField.setText("");
                caseCountField.setText("");
                hospCountField.setText("");
                deathCountField.setText("");
                totalHospIndField.setText("");
                pcrTestCountField.setText("");
                pcrTestPosCountField.setText("");
                pcrTestPosPercentField.setText("");
            }
        });

        JButton nextButton = new JButton("Next");
        nextButton.setBounds(350, 600, 130, 30);
        panel.add(nextButton);
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                count++;
                for (int i = 0; i < regionManager.regionArrayList.size(); i++) {
                    if (count == regionManager.regionArrayList.size()) {
                        count = 0;
                        break;
                    }
                    regionField.setText(regionManager.regionArrayList.get(count).geo_id());
                    popField.setText(String.valueOf(regionManager.regionArrayList.get(count).pop()));
                    caseCountField.setText(String.valueOf(regionManager.regionArrayList.get(count).case_count()));
                    hospCountField.setText(String.valueOf(regionManager.regionArrayList.get(count).hosp_count()));
                    deathCountField.setText(String.valueOf(regionManager.regionArrayList.get(count).death_count()));
                    totalHospIndField.setText(String.valueOf(regionManager.regionArrayList.get(count).total_hosp_incidental()));
                    pcrTestCountField.setText(String.valueOf(regionManager.regionArrayList.get(count).pcr_test_count()));
                    pcrTestPosCountField.setText(String.valueOf(regionManager.regionArrayList.get(count).pcr_test_pos_count()));
                    pcrTestPosPercentField.setText(String.valueOf(regionManager.regionArrayList.get(count).pcr_test_pos_percent()));
                }
            }
        });

        JButton prevButton = new JButton("Previous");
        prevButton.setBounds(200, 600, 130, 30);
        panel.add(prevButton);
        prevButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                count--;
                for (int i = 0; i < regionManager.regionArrayList.size(); i++) {
                    if (count < 0) {
                        count = regionManager.regionArrayList.size() - 1;
                    }
                    regionField.setText(regionManager.regionArrayList.get(count).geo_id());
                    popField.setText(String.valueOf(regionManager.regionArrayList.get(count).pop()));
                    caseCountField.setText(String.valueOf(regionManager.regionArrayList.get(count).case_count()));
                    hospCountField.setText(String.valueOf(regionManager.regionArrayList.get(count).hosp_count()));
                    deathCountField.setText(String.valueOf(regionManager.regionArrayList.get(count).death_count()));
                    totalHospIndField.setText(String.valueOf(regionManager.regionArrayList.get(count).total_hosp_incidental()));
                    pcrTestCountField.setText(String.valueOf(regionManager.regionArrayList.get(count).pcr_test_count()));
                    pcrTestPosCountField.setText(String.valueOf(regionManager.regionArrayList.get(count).pcr_test_pos_count()));
                    pcrTestPosPercentField.setText(String.valueOf(regionManager.regionArrayList.get(count).pcr_test_pos_percent()));
                }
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) throws FileNotFoundException {
        new RegionViewer();
    }
}
