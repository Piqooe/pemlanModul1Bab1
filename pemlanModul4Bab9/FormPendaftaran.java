package tugas_praktikum.pemlanModul4Bab9;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;


public class FormPendaftaran extends JFrame {
    private JTextField textNamaLengkap, textTanggalLahir, textNomorPendaftaran, textNoTelp, textEmail;
    private JTextArea textAlamat;
    private JButton btnSubmit;

    public FormPendaftaran() {
        setTitle("Form Pendaftaran Mahasiswa Baru");
        setSize(550, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));
        mainPanel.setBackground(new Color(240, 242, 245));

        JLabel titleLabel = new JLabel("Form Pendaftaran Mahasiswa Baru", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 22));
        titleLabel.setForeground(new Color(40, 40, 40));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridBagLayout());
        formPanel.setBackground(mainPanel.getBackground());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(8, 10, 8, 10);
        
        Font labelFont = new Font("Segoe UI", Font.BOLD, 14);
        Font inputFont = new Font("Segoe UI", Font.PLAIN, 14);
        Color textColor = new Color(60, 60, 60);

        String[] labels = {"Nama Lengkap", "Tanggal Lahir", "Nomor Pendaftaran", "No. Telp", "Alamat", "E-mail"};
        JComponent[] inputs = new JComponent[6];

        textNamaLengkap = createTextField(inputFont);
        textTanggalLahir = createTextField(inputFont);
        textNomorPendaftaran = createTextField(inputFont);
        textNoTelp = createTextField(inputFont);
        
        textAlamat = new JTextArea(4, 20);
        textAlamat.setFont(inputFont);
        textAlamat.setLineWrap(true);
        textAlamat.setWrapStyleWord(true);
        JScrollPane alamatScroll = new JScrollPane(textAlamat);
        
        textEmail = createTextField(inputFont);

        inputs[0] = textNamaLengkap;
        inputs[1] = textTanggalLahir;
        inputs[2] = textNomorPendaftaran;
        inputs[3] = textNoTelp;
        inputs[4] = alamatScroll;
        inputs[5] = textEmail;

        for (int i = 0; i < labels.length; i++) {
            gbc.gridx = 0;
            gbc.gridy = i;
            gbc.weightx = 0.3;
            JLabel label = new JLabel(labels[i]);
            label.setFont(labelFont);
            label.setForeground(textColor);
            formPanel.add(label, gbc);

            gbc.gridx = 1;
            gbc.weightx = 0.7;
            if (i == 4) {
                gbc.fill = GridBagConstraints.BOTH;
                gbc.weighty = 1.0;
            } else {
                gbc.fill = GridBagConstraints.HORIZONTAL;
                gbc.weighty = 0.0;
            }
            formPanel.add(inputs[i], gbc);
        }

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.setBackground(mainPanel.getBackground());
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        
        btnSubmit = new JButton("Submit");
        btnSubmit.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnSubmit.setFocusPainted(false);
        btnSubmit.setPreferredSize(new Dimension(100, 35));
        
        buttonPanel.add(btnSubmit);
        
        mainPanel.add(formPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        
        add(mainPanel);
        
        btnSubmit.addActionListener(e -> handleSubmit());
    }

    private JTextField createTextField(Font font) {
        JTextField textField = new JTextField();
        textField.setFont(font);
        textField.setPreferredSize(new Dimension(200, 30));
        return textField;
    }

    private void handleSubmit() {
        String nama = textNamaLengkap.getText().trim();
        String tglLahir = textTanggalLahir.getText().trim();
        String noPend = textNomorPendaftaran.getText().trim();
        String noTelp = textNoTelp.getText().trim();
        String alamat = textAlamat.getText().trim();
        String email = textEmail.getText().trim();

        if (nama.isEmpty() || tglLahir.isEmpty() || noPend.isEmpty() || 
            noTelp.isEmpty() || alamat.isEmpty() || email.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Semua kolom harus terisi!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this, "Apakah anda yakin data yang Anda isi sudah benar?", "Konfirmasi", JOptionPane.OK_CANCEL_OPTION);
        if (confirm == JOptionPane.OK_OPTION) {
            showDataWindow(nama, tglLahir, noPend, noTelp, alamat, email);
        }
    }
    
    private void showDataWindow(String nama, String tglLahir, String noPend, String noTelp, String alamat, String email) {
        JFrame resultFrame = new JFrame("Data Mahasiswa");
        resultFrame.setSize(450, 400);
        resultFrame.setLocationRelativeTo(this);
        
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.setBackground(new Color(240, 242, 245));

        JLabel titleLabel = new JLabel("Data Mahasiswa", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 15, 0));
        panel.add(titleLabel, BorderLayout.NORTH);

        JTextArea dataArea = new JTextArea();
        dataArea.setEditable(false);
        dataArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        
        Border innerBorder = BorderFactory.createEmptyBorder(15, 15, 15, 15);
        Border outerBorder = BorderFactory.createLineBorder(new Color(150, 150, 150), 1);
        dataArea.setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
        
        String dataText = String.format(
            "%-18s: %s\n" +
            "%-18s: %s\n" +
            "%-18s: %s\n" +
            "%-18s: %s\n" +
            "%-18s: %s\n" +
            "%-18s: %s\n",
            "Nama", nama,
            "Tanggal Lahir", tglLahir,
            "No.Pendaftaran", noPend,
            "No.Telp", noTelp,
            "Alamat", alamat,
            "E-mail", email
        );
        dataArea.setText(dataText);
        dataArea.setBackground(Color.WHITE);
        
        panel.add(dataArea, BorderLayout.CENTER);
        resultFrame.add(panel);
        resultFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }
            new FormPendaftaran().setVisible(true);
        });
    }
}
