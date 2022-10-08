package uiTimKiem;

import javax.swing.JFrame;

public class FormTimKiemDonDatHang extends JFrame {

	private javax.swing.JButton btnCheck;
    private javax.swing.JComboBox<String> cbbName;
    public FormTimKiemDonDatHang() {
		// TODO Auto-generated constructor stub
    	initComponents();
	}
	private void initComponents() {

        cbbName = new javax.swing.JComboBox<>();
        btnCheck = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        cbbName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bui Nhut Duy", "Vo Minh Chien", "Vo Trong Tai", "Luong Viet Thanh", "Truong Van Tuan", "Tran Quoc Trong", "Bui Nhut Duy", "Vo Minh Chien", "Vo Trong Tai", "Luong Viet Thanh", "Truong Van Tuan", "Tran Quoc Trong" }));

        btnCheck.setText("Check");


        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(cbbName, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCheck)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbbName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCheck))
                .addContainerGap(214, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }
}
