package org.pan.privilege;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Table;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.swt.layout.RowData;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.dnd.DragSource;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTarget;

public class PrivilegeMainViewer extends Shell {
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;
	private Table table_1;
	private Table table;
	private Table table_2;
	private Table table_3;
	private Table table_4;
	private Text text_4;
	private Text text_5;
	private Text text_6;
	private Text text_7;
	private Text text_8;
	private Text text_9;
	private Text text_10;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			PrivilegeMainViewer shell = new PrivilegeMainViewer(display);
			shell.open();
			shell.layout();
			while (!shell.isDisposed()) {
				if (!display.readAndDispatch()) {
					display.sleep();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the shell.
	 * @param display
	 */
	public PrivilegeMainViewer(Display display) {
		super(display, SWT.SHELL_TRIM);
		setMinimumSize(new Point(1024, 768));
		
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("SWT Application");
		this.setLayout(new FillLayout());
		SashForm form = new SashForm(this, SWT.HORIZONTAL);

	    Composite composite_left = new Composite(form, SWT.BORDER);
	    composite_left.setLayout(new FillLayout());
	    
	    SashForm sashForm = new SashForm(composite_left, SWT.VERTICAL);
	    
	    Group composite_device = new Group(sashForm, SWT.NONE);
	    composite_device.setText("设备权限分配");
	    GridLayout gl_composite_device = new GridLayout(1, false);
	    gl_composite_device.horizontalSpacing = 0;
	    gl_composite_device.verticalSpacing = 0;
	    gl_composite_device.marginWidth = 0;
	    gl_composite_device.marginHeight = 0;
	    composite_device.setLayout(gl_composite_device);
	    
	    Composite composite_6 = new Composite(composite_device, SWT.NONE);
	    RowLayout rl_composite_6 = new RowLayout(SWT.HORIZONTAL);
	    rl_composite_6.center = true;
	    composite_6.setLayout(rl_composite_6);
	    composite_6.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
	    
	    Label lblNewLabel_1 = new Label(composite_6, SWT.NONE);
	    lblNewLabel_1.setText("设备标识：");
	    
	    text_6 = new Text(composite_6, SWT.BORDER);
	    text_6.setLayoutData(new RowData(60, SWT.DEFAULT));
	    
	    Label label_9 = new Label(composite_6, SWT.NONE);
	    label_9.setText("设备名称：");
	    
	    text_7 = new Text(composite_6, SWT.BORDER);
	    text_7.setLayoutData(new RowData(60, SWT.DEFAULT));
	    
	    Label label_10 = new Label(composite_6, SWT.NONE);
	    label_10.setText("地点：");
	    
	    text_8 = new Text(composite_6, SWT.BORDER);
	    text_8.setLayoutData(new RowData(60, SWT.DEFAULT));
	    
	    Button btnNewButton_3 = new Button(composite_6, SWT.NONE);
	    btnNewButton_3.setToolTipText("单击查询系统中的设备");
	    btnNewButton_3.setImage(SWTResourceManager.getImage(PrivilegeMainViewer.class, "/image/search_16.png"));
	    
	    Composite composite_7 = new Composite(composite_device, SWT.NONE);
	    composite_7.setLayoutData(new GridData(GridData.FILL_BOTH));
	    composite_7.setLayout(new FillLayout());
	    
	    SashForm sashForm_device = new SashForm(composite_7, SWT.NONE);
	    
	    Composite composite_deviceGroup = new Composite(sashForm_device, SWT.NONE);
	    composite_deviceGroup.setLayout(new FillLayout(SWT.HORIZONTAL));
	    
	    TreeViewer treeViewer = new TreeViewer(composite_deviceGroup, SWT.BORDER);
	    Tree tree = treeViewer.getTree();
	    tree.setHeaderVisible(true);
	    
	    TreeViewerColumn treeViewerColumn = new TreeViewerColumn(treeViewer, SWT.NONE);
	    TreeColumn treeColumn = treeViewerColumn.getColumn();
	    treeColumn.setWidth(100);
	    treeColumn.setText("设备组名称");
	    
	    Composite composite_deviceList = new Composite(sashForm_device, SWT.NONE);
	    composite_deviceList.setLayout(new FillLayout(SWT.HORIZONTAL));
	    
	    TableViewer tableViewer = new TableViewer(composite_deviceList, SWT.BORDER | SWT.FULL_SELECTION);
	    table = tableViewer.getTable();
	    table.setToolTipText("设备列表");
	    table.setLinesVisible(true);
	    table.setHeaderVisible(true);
	    
	    TableViewerColumn tableViewerColumn = new TableViewerColumn(tableViewer, SWT.NONE);
	    TableColumn tableColumn = tableViewerColumn.getColumn();
	    tableColumn.setWidth(100);
	    tableColumn.setText("设备标识");
	    
	    TableViewerColumn tableViewerColumn_1 = new TableViewerColumn(tableViewer, SWT.NONE);
	    TableColumn tableColumn_1 = tableViewerColumn_1.getColumn();
	    tableColumn_1.setWidth(100);
	    tableColumn_1.setText("设备名称");
	    
	    TableViewerColumn tableViewerColumn_2 = new TableViewerColumn(tableViewer, SWT.NONE);
	    TableColumn tableColumn_2 = tableViewerColumn_2.getColumn();
	    tableColumn_2.setWidth(100);
	    tableColumn_2.setText("地点");
	    
	    Composite composite_10 = new Composite(composite_device, SWT.NONE);
	    RowLayout rl_composite_10 = new RowLayout(SWT.HORIZONTAL);
	    rl_composite_10.marginTop = 0;
	    rl_composite_10.marginRight = 0;
	    rl_composite_10.marginLeft = 0;
	    rl_composite_10.marginBottom = 0;
	    rl_composite_10.center = true;
	    composite_10.setLayout(rl_composite_10);
	    GridData gd_composite_10 = new GridData(GridData.FILL_HORIZONTAL);
	    gd_composite_10.horizontalAlignment = SWT.RIGHT;
	    composite_10.setLayoutData(gd_composite_10);
	    
	    Button btnNewButton_5 = new Button(composite_10, SWT.NONE);
	    btnNewButton_5.setImage(SWTResourceManager.getImage(PrivilegeMainViewer.class, "/image/more_16 .png"));
	    btnNewButton_5.setToolTipText("单击加载更多设备");
	    
	    sashForm_device.setWeights(new int[] {2, 3});
	    
	    Group composite_user = new Group(sashForm, SWT.NONE);
	    composite_user.setText("用户权限分配");
	    GridLayout gl_composite_user = new GridLayout(1, false);
	    gl_composite_user.verticalSpacing = 0;
	    gl_composite_user.marginWidth = 0;
	    gl_composite_user.marginHeight = 0;
	    composite_user.setLayout(gl_composite_user);
	    
	    Composite composite_8 = new Composite(composite_user, SWT.NONE);
	    RowLayout rl_composite_8 = new RowLayout(SWT.HORIZONTAL);
	    rl_composite_8.center = true;
	    composite_8.setLayout(rl_composite_8);
	    composite_8.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
	    
	    Label label_11 = new Label(composite_8, SWT.NONE);
	    label_11.setText("用户编号：");
	    
	    text_9 = new Text(composite_8, SWT.BORDER);
	    text_9.setLayoutData(new RowData(60, SWT.DEFAULT));
	    
	    Label label_12 = new Label(composite_8, SWT.NONE);
	    label_12.setText("用户姓名：");
	    
	    text_10 = new Text(composite_8, SWT.BORDER);
	    text_10.setLayoutData(new RowData(60, SWT.DEFAULT));
	    
	    Label label_13 = new Label(composite_8, SWT.NONE);
	    label_13.setText("性别：");
	    
	    ComboViewer comboViewer_1 = new ComboViewer(composite_8, SWT.NONE);
	    comboViewer_1.setLabelProvider(new LabelProvider());
	    comboViewer_1.setContentProvider(new ArrayContentProvider());
	    comboViewer_1.setInput(new String[]{"男","女"});
	    Combo combo_1 = comboViewer_1.getCombo();
	    combo_1.setLayoutData(new RowData(60, SWT.DEFAULT));
	    combo_1.select(0);
	    
	    Button btnNewButton_4 = new Button(composite_8, SWT.NONE);
	    btnNewButton_4.setToolTipText("单击查询系统中的用户");
	    btnNewButton_4.setImage(SWTResourceManager.getImage(PrivilegeMainViewer.class, "/image/search_16.png"));
	    
	    Composite composite_9 = new Composite(composite_user, SWT.NONE);
	    composite_9.setLayout(new FillLayout(SWT.HORIZONTAL));
	    composite_9.setLayoutData(new GridData(GridData.FILL_BOTH));
	    
	    SashForm sashForm_user = new SashForm(composite_9, SWT.NONE);
	    
	    Composite composite_userGroup = new Composite(sashForm_user, SWT.NONE);
	    composite_userGroup.setLayout(new FillLayout(SWT.HORIZONTAL));
	    
	    TreeViewer treeViewer_1 = new TreeViewer(composite_userGroup, SWT.BORDER);
	    Tree tree_1 = treeViewer_1.getTree();
	    tree_1.setHeaderVisible(true);
	    
	    TreeViewerColumn treeViewerColumn_1 = new TreeViewerColumn(treeViewer_1, SWT.NONE);
	    TreeColumn treeColumn_1 = treeViewerColumn_1.getColumn();
	    treeColumn_1.setWidth(100);
	    treeColumn_1.setText("用户组名称");
	    
	    Composite composite_userList = new Composite(sashForm_user, SWT.NONE);
	    composite_userList.setLayout(new FillLayout(SWT.HORIZONTAL));
	    
	    TableViewer tableViewer_1 = new TableViewer(composite_userList, SWT.BORDER | SWT.FULL_SELECTION);
	    table_1 = tableViewer_1.getTable();
	    table_1.setLinesVisible(true);
	    table_1.setHeaderVisible(true);
	    
	    TableViewerColumn tableViewerColumn_3 = new TableViewerColumn(tableViewer_1, SWT.NONE);
	    TableColumn tableColumn_3 = tableViewerColumn_3.getColumn();
	    tableColumn_3.setWidth(100);
	    tableColumn_3.setText("用户编号");
	    
	    TableViewerColumn tableViewerColumn_4 = new TableViewerColumn(tableViewer_1, SWT.NONE);
	    TableColumn tableColumn_4 = tableViewerColumn_4.getColumn();
	    tableColumn_4.setWidth(100);
	    tableColumn_4.setText("用户名称");
	    
	    TableViewerColumn tableViewerColumn_5 = new TableViewerColumn(tableViewer_1, SWT.NONE);
	    TableColumn tableColumn_5 = tableViewerColumn_5.getColumn();
	    tableColumn_5.setWidth(100);
	    tableColumn_5.setText("性别");
	    sashForm_user.setWeights(new int[] {2, 3});
	    
	    Composite composite_11 = new Composite(composite_user, SWT.NONE);
	    GridData gd_composite_11 = new GridData(GridData.FILL_HORIZONTAL);
	    gd_composite_11.horizontalAlignment = SWT.RIGHT;
	    composite_11.setLayoutData(gd_composite_11);
	    RowLayout rl_composite_11 = new RowLayout(SWT.HORIZONTAL);
	    rl_composite_11.spacing = 0;
	    rl_composite_11.marginTop = 0;
	    rl_composite_11.marginRight = 0;
	    rl_composite_11.marginLeft = 0;
	    rl_composite_11.marginBottom = 0;
	    rl_composite_11.center = true;
	    composite_11.setLayout(rl_composite_11);
	    
	    Button btnNewButton_6 = new Button(composite_11, SWT.NONE);
	    btnNewButton_6.setToolTipText("单击加载更多用户");
	    btnNewButton_6.setImage(SWTResourceManager.getImage(PrivilegeMainViewer.class, "/image/more_16 .png"));
	    
	    sashForm.setWeights(new int[] {1, 1});

	    Group composite_right = new Group(form, SWT.NONE);
	    composite_right.setText("己分配权限");
	    composite_right.setLayout(new FillLayout(SWT.HORIZONTAL));
	    
	    SashForm sashForm_1 = new SashForm(composite_right, SWT.VERTICAL);
	    
	    Composite omposite_privilege_list = new Composite(sashForm_1, SWT.BORDER);
	    omposite_privilege_list.setLayout(new FillLayout(SWT.HORIZONTAL));
	    
	    SashForm sashForm_privilege = new SashForm(omposite_privilege_list, SWT.NONE);
	    
	    Composite composite_privilege_device = new Composite(sashForm_privilege, SWT.NONE);
	    GridLayout gl_composite_privilege_device = new GridLayout(1, true);
	    gl_composite_privilege_device.marginBottom = 7;
	    gl_composite_privilege_device.verticalSpacing = 0;
	    gl_composite_privilege_device.horizontalSpacing = 0;
	    gl_composite_privilege_device.marginHeight = 0;
	    gl_composite_privilege_device.marginWidth = 0;
	    composite_privilege_device.setLayout(gl_composite_privilege_device);
	    
	    Composite composite_4 = new Composite(composite_privilege_device, SWT.NONE);
	    composite_4.setLayout(new RowLayout(SWT.HORIZONTAL));
	    GridData gd_composite_4 = new GridData(GridData.FILL_HORIZONTAL);
	    gd_composite_4.horizontalAlignment = SWT.LEFT;
	    composite_4.setLayoutData(gd_composite_4);
	    
	    Label label_8 = new Label(composite_4, SWT.NONE);
	    label_8.setText("名称：");
	    
	    text_4 = new Text(composite_4, SWT.BORDER);
	    text_4.setLayoutData(new RowData(60, SWT.DEFAULT));
	    
	    Button btnNewButton_2 = new Button(composite_4, SWT.NONE);
	    btnNewButton_2.setToolTipText("查询");
	    btnNewButton_2.setImage(SWTResourceManager.getImage(PrivilegeMainViewer.class, "/image/search_16.png"));
	    
	    Button button_6 = new Button(composite_4, SWT.NONE);
	    button_6.setToolTipText("删除");
	    button_6.setImage(SWTResourceManager.getImage(PrivilegeMainViewer.class, "/image/remove_16.png"));
	    
	    TableViewer tableViewer_2 = new TableViewer(composite_privilege_device, SWT.BORDER | SWT.FULL_SELECTION);
	    table_2 = tableViewer_2.getTable();
	    table_2.setLinesVisible(true);
	    table_2.setHeaderVisible(true);
	    table_2.setLayoutData(new GridData(GridData.FILL_BOTH));
	    
	    TableViewerColumn tableViewerColumn_6 = new TableViewerColumn(tableViewer_2, SWT.NONE);
	    TableColumn tableColumn_6 = tableViewerColumn_6.getColumn();
	    tableColumn_6.setWidth(100);
	    tableColumn_6.setText("名称");
	    
	    TableViewerColumn tableViewerColumn_7 = new TableViewerColumn(tableViewer_2, SWT.NONE);
	    TableColumn tableColumn_7 = tableViewerColumn_7.getColumn();
	    tableColumn_7.setWidth(100);
	    tableColumn_7.setText("设备/设备组");
	    
	    Composite composite_12 = new Composite(composite_privilege_device, SWT.NONE);
	    RowLayout rl_composite_12 = new RowLayout(SWT.HORIZONTAL);
	    rl_composite_12.marginTop = 0;
	    rl_composite_12.marginRight = 0;
	    rl_composite_12.marginLeft = 0;
	    rl_composite_12.marginBottom = 0;
	    rl_composite_12.center = true;
	    composite_12.setLayout(rl_composite_12);
	    GridData gd_composite_12 = new GridData(GridData.FILL_HORIZONTAL);
	    gd_composite_12.horizontalAlignment = SWT.RIGHT;
	    composite_12.setLayoutData(gd_composite_12);
	    
	    Button btnNewButton_7 = new Button(composite_12, SWT.NONE);
	    btnNewButton_7.setImage(SWTResourceManager.getImage(PrivilegeMainViewer.class, "/image/more_16 .png"));
	    
	    Composite composite_privilege_user = new Composite(sashForm_privilege, SWT.NONE);
	    GridLayout gl_composite_privilege_user = new GridLayout(1, false);
	    gl_composite_privilege_user.horizontalSpacing = 0;
	    gl_composite_privilege_user.verticalSpacing = 0;
	    gl_composite_privilege_user.marginHeight = 0;
	    gl_composite_privilege_user.marginWidth = 0;
	    composite_privilege_user.setLayout(gl_composite_privilege_user);
	    
	    Composite composite_5 = new Composite(composite_privilege_user, SWT.NONE);
	    composite_5.setLayout(new RowLayout(SWT.HORIZONTAL));
	    
	    Label lblNewLabel = new Label(composite_5, SWT.NONE);
	    lblNewLabel.setText("名称：");
	    
	    text_5 = new Text(composite_5, SWT.BORDER);
	    text_5.setLayoutData(new RowData(60, SWT.DEFAULT));
	    
	    Button button = new Button(composite_5, SWT.NONE);
	    button.setToolTipText("读卡");
	    button.setImage(SWTResourceManager.getImage(PrivilegeMainViewer.class, "/image/cardReader_16.png"));
	    
	    Button button_5 = new Button(composite_5, SWT.NONE);
	    button_5.setToolTipText("查询");
	    button_5.setImage(SWTResourceManager.getImage(PrivilegeMainViewer.class, "/image/search_16.png"));
	    
	    Button button_7 = new Button(composite_5, SWT.NONE);
	    button_7.setToolTipText("删除");
	    button_7.setImage(SWTResourceManager.getImage(PrivilegeMainViewer.class, "/image/remove_16.png"));
	    
	    TableViewer tableViewer_3 = new TableViewer(composite_privilege_user, SWT.BORDER | SWT.FULL_SELECTION);
	    table_3 = tableViewer_3.getTable();
	    table_3.setLinesVisible(true);
	    table_3.setHeaderVisible(true);
	    table_3.setLayoutData(new GridData(GridData.FILL_BOTH));
	    
	    TableViewerColumn tableViewerColumn_8 = new TableViewerColumn(tableViewer_3, SWT.NONE);
	    TableColumn tableColumn_8 = tableViewerColumn_8.getColumn();
	    tableColumn_8.setWidth(100);
	    tableColumn_8.setText("名称");
	    
	    TableViewerColumn tableViewerColumn_9 = new TableViewerColumn(tableViewer_3, SWT.NONE);
	    TableColumn tableColumn_9 = tableViewerColumn_9.getColumn();
	    tableColumn_9.setWidth(100);
	    tableColumn_9.setText("用户/用户组");
	    
	    Composite composite_13 = new Composite(composite_privilege_user, SWT.NONE);
	    RowLayout rl_composite_13 = new RowLayout(SWT.HORIZONTAL);
	    rl_composite_13.marginBottom = 7;
	    rl_composite_13.marginTop = 0;
	    rl_composite_13.marginRight = 0;
	    rl_composite_13.marginLeft = 0;
	    composite_13.setLayout(rl_composite_13);
	    GridData gd_composite_13 = new GridData(GridData.FILL_HORIZONTAL);
	    gd_composite_13.horizontalAlignment = SWT.RIGHT;
	    composite_13.setLayoutData(gd_composite_13);
	    
	    Button button_10 = new Button(composite_13, SWT.NONE);
	    button_10.setToolTipText("单击加载更多设备");
	    button_10.setImage(SWTResourceManager.getImage(PrivilegeMainViewer.class, "/image/more_16 .png"));
	    
	    
	    sashForm_privilege.setWeights(new int[] {1, 1, 1, 1});
	    
	    Composite omposite_privilege_detail = new Composite(sashForm_1, SWT.NONE);
	    omposite_privilege_detail.setLayout(new FillLayout(SWT.HORIZONTAL));
	    
	    TabFolder tabFolder = new TabFolder(omposite_privilege_detail, SWT.NONE);
	    
	    TabItem tabItem_privilege_detail = new TabItem(tabFolder, SWT.NONE);
	    tabItem_privilege_detail.setText("权限详情");
	    
	    Composite composite2 = new Composite(tabFolder, SWT.NONE);
	    GridLayout gl_composite2 = new GridLayout(1, false);
	    gl_composite2.verticalSpacing = 0;
	    gl_composite2.marginWidth = 0;
	    gl_composite2.marginHeight = 0;
	    composite2.setLayout(gl_composite2);
	    tabItem_privilege_detail.setControl(composite2);
	    
	    Composite composite = new Composite(composite2, SWT.NONE);
	    composite.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, true, 1, 1));
	    GridLayout gl_composite = new GridLayout(4, false);
	    gl_composite.horizontalSpacing = 10;
	    gl_composite.verticalSpacing = 10;
	    gl_composite.marginHeight = 0;
	    gl_composite.marginWidth = 0;
	    composite.setLayout(gl_composite);
	   
	    
	    Label label = new Label(composite, SWT.NONE);
	    label.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
	    label.setText("设备组");
	    
	    text = new Text(composite, SWT.BORDER);
	    GridData gd_text = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
	    gd_text.widthHint = 130;
	    text.setLayoutData(gd_text);
	    
	    Label label_2 = new Label(composite, SWT.NONE);
	    label_2.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
	    label_2.setText("设 备");
	    
	    text_2 = new Text(composite, SWT.BORDER);
	    GridData gd_text_2 = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
	    gd_text_2.widthHint = 130;
	    text_2.setLayoutData(gd_text_2);
	    
	    Label label_1 = new Label(composite, SWT.NONE);
	    label_1.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
	    label_1.setText("用户组");
	    
	    text_1 = new Text(composite, SWT.BORDER);
	    GridData gd_text_1 = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
	    gd_text_1.widthHint = 130;
	    text_1.setLayoutData(gd_text_1);
	    
	    Label label_3 = new Label(composite, SWT.NONE);
	    label_3.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
	    label_3.setText("用 户");
	    
	    text_3 = new Text(composite, SWT.BORDER);
	    GridData gd_text_3 = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
	    gd_text_3.widthHint = 130;
	    text_3.setLayoutData(gd_text_3);
	    
	    Label label_6 = new Label(composite, SWT.NONE);
	    label_6.setText("检 查 周 表");
	    
	    Composite composite_3 = new Composite(composite, SWT.BORDER);
	    GridData gd_composite_3 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
	    gd_composite_3.widthHint = 134;
	    composite_3.setLayoutData(gd_composite_3);
	    composite_3.setLayout(new FillLayout());
	    
	    Button button_3 = new Button(composite_3, SWT.RADIO);
	    button_3.setText("检查");
	    
	    Button button_4 = new Button(composite_3, SWT.RADIO);
	    button_4.setSelection(true);
	    button_4.setText("不检查");
	    
	    Label label_7 = new Label(composite, SWT.NONE);
	    label_7.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
	    label_7.setText("周 表");
	    
	    ComboViewer comboViewer = new ComboViewer(composite, SWT.NONE);
	    comboViewer.setContentProvider(new ArrayContentProvider());
	    comboViewer.setLabelProvider(new LabelProvider());
	    comboViewer.setInput(new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09"});
	    GridData gd_combo = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
	    gd_combo.widthHint = 115;
	    Combo combo = comboViewer.getCombo();
	    combo.setLayoutData(gd_combo);
	    combo.select(0);
	    
	    Label label_4 = new Label(composite, SWT.NONE);
	    label_4.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
	    label_4.setText("检查有效期");
	    
	    Composite composite_2 = new Composite(composite, SWT.BORDER);
	    GridData gd_composite_2 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
	    gd_composite_2.widthHint = 134;
	    composite_2.setLayoutData(gd_composite_2);
	    composite_2.setLayout(new FillLayout());
	    
	    Button button_1 = new Button(composite_2, SWT.RADIO);
	    button_1.setText("检查");
	    
	    Button button_2 = new Button(composite_2, SWT.RADIO);
	    button_2.setSelection(true);
	    button_2.setText("不检查");
	    
	    Label label_5 = new Label(composite, SWT.NONE);
	    label_5.setText("有效期");
	    
	    DateTime dateTime = new DateTime(composite, SWT.BORDER | SWT.LONG);
	    GridData gd_dateTime = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
	    gd_dateTime.widthHint = 139;
	    dateTime.setLayoutData(gd_dateTime);
	    
	    Composite composite_1 = new Composite(composite, SWT.NONE);
	    composite_1.setLayout(new GridLayout(2, false));
	    GridData gd_composite_1 = new GridData(GridData.FILL_BOTH);
	    gd_composite_1.horizontalAlignment = SWT.CENTER;
	    gd_composite_1.horizontalSpan = 4;
	    composite_1.setLayoutData(gd_composite_1);
	    
	    Button btnNewButton = new Button(composite_1, SWT.NONE);
	    btnNewButton.setImage(SWTResourceManager.getImage(PrivilegeMainViewer.class, "/image/add_privilege_24.png"));
	    GridData gd_btnNewButton = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
	    gd_btnNewButton.heightHint = 50;
	    gd_btnNewButton.widthHint = 65;
	    btnNewButton.setLayoutData(gd_btnNewButton);
	    btnNewButton.setText("添加");
	    
	    Button btnNewButton_1 = new Button(composite_1, SWT.NONE);
	    btnNewButton_1.setImage(SWTResourceManager.getImage(PrivilegeMainViewer.class, "/image/update_privilege_24.png"));
	    GridData gd_btnNewButton_1 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
	    gd_btnNewButton_1.widthHint = 65;
	    gd_btnNewButton_1.heightHint = 50;
	    btnNewButton_1.setLayoutData(gd_btnNewButton_1);
	    btnNewButton_1.setText("保存");
	    
	    TabItem tabItem_privilege_cardList = new TabItem(tabFolder, SWT.NONE);
	    tabItem_privilege_cardList.setText("权限卡片列表");
	    
	    Composite composite_14 = new Composite(tabFolder, SWT.NONE);
	    tabItem_privilege_cardList.setControl(composite_14);
	    GridLayout gl_composite_14 = new GridLayout(1, false);
	    gl_composite_14.marginTop = 18;
	    gl_composite_14.horizontalSpacing = 0;
	    gl_composite_14.verticalSpacing = 0;
	    gl_composite_14.marginWidth = 0;
	    gl_composite_14.marginHeight = 0;
	    composite_14.setLayout(gl_composite_14);
	    
	    TableViewer tableViewer_4 = new TableViewer(composite_14, SWT.BORDER | SWT.FULL_SELECTION);
	    table_4 = tableViewer_4.getTable();
	    table_4.setLinesVisible(true);
	    table_4.setHeaderVisible(true);
	    table_4.setLayoutData(new GridData(GridData.FILL_BOTH));
	    
	    TableViewerColumn tableViewerColumn_13 = new TableViewerColumn(tableViewer_4, SWT.NONE);
	    TableColumn tableColumn_13 = tableViewerColumn_13.getColumn();
	    tableColumn_13.setWidth(100);
	    tableColumn_13.setText("用户编号");
	    
	    TableViewerColumn tableViewerColumn_12 = new TableViewerColumn(tableViewer_4, SWT.NONE);
	    TableColumn tableColumn_12 = tableViewerColumn_12.getColumn();
	    tableColumn_12.setWidth(100);
	    tableColumn_12.setText("用户名称");
	    
	    TableViewerColumn tableViewerColumn_10 = new TableViewerColumn(tableViewer_4, SWT.NONE);
	    TableColumn tableColumn_10 = tableViewerColumn_10.getColumn();
	    tableColumn_10.setWidth(100);
	    tableColumn_10.setText("设备编号");
	    
	    TableViewerColumn tableViewerColumn_11 = new TableViewerColumn(tableViewer_4, SWT.NONE);
	    TableColumn tableColumn_11 = tableViewerColumn_11.getColumn();
	    tableColumn_11.setWidth(100);
	    tableColumn_11.setText("卡片内码");
	    
	    Composite composite_15 = new Composite(composite_14, SWT.NONE);
	    GridData gd_composite_15 = new GridData(GridData.FILL_HORIZONTAL);
	    gd_composite_15.horizontalAlignment = SWT.RIGHT;
	    composite_15.setLayoutData(gd_composite_15);
	    RowLayout rl_composite_15 = new RowLayout(SWT.HORIZONTAL);
	    rl_composite_15.marginTop = 0;
	    rl_composite_15.marginRight = 0;
	    rl_composite_15.marginLeft = 0;
	    rl_composite_15.marginBottom = 0;
	    composite_15.setLayout(rl_composite_15);
	    
	    Button btnNewButton_8 = new Button(composite_15, SWT.NONE);
	    btnNewButton_8.setImage(SWTResourceManager.getImage(PrivilegeMainViewer.class, "/image/more_16 .png"));
	    
	    sashForm_1.setWeights(new int[] {1, 1});

	    form.setWeights(new int[] {1,1});
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
