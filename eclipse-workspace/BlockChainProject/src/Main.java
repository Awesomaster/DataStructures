import org.eclipse.swt.*;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.*;

public class Main {
	public static String labelText;
	
	public Main() {
		labelText = "";
	}
	
	public static String addLine(String str, String initial) {
		return initial + "\n" + str;
	}
	
	public static void balanceShell(Display display, BlockChain chain) {
		// FROM HERE WE HAVE THE WINDOW THAT MINES
		
		Shell shell = new Shell(display, SWT.CLOSE);
		shell.setSize(500, 300); 
        shell.setText("Get Balance");
		shell.open();

        Text textAddress = new Text(shell, SWT.NONE);
		textAddress.setText("Your Address....");
		textAddress.setSize(100,25);
		textAddress.setLocation(200,0);
		
		Button balanceGet = new Button(shell, SWT.PUSH);
		balanceGet.setText("Get Balance");
		balanceGet.setSize(100,25);
		balanceGet.setLocation(350,0);
		
		balanceGet.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent event) {       
				System.out.println("Balance of: " + textAddress.getText() + " is $" + chain.getBalanceOfAddress(textAddress.getText()));
	            shell.dispose(); 
			}

			public void widgetDefaultSelected(SelectionEvent e) {}
		});
	}
	
	public static void miningShell(Display display, BlockChain chain) {
		// FROM HERE WE HAVE THE WINDOW THAT MINES
		
		Shell shell = new Shell(display, SWT.CLOSE);
		shell.setSize(500, 300); 
        shell.setText("Mining");
		shell.open();

        Text textAddress = new Text(shell, SWT.NONE);
		textAddress.setText("Your Address....");
		textAddress.setSize(100,25);
		textAddress.setLocation(200,0);
		
		Button mineBlock = new Button(shell, SWT.PUSH);
		mineBlock.setText("Mine Block");
		mineBlock.setSize(100,25);
		mineBlock.setLocation(350,0);
		
		mineBlock.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent event) {       
				chain.minePendingTransactions(textAddress.getText());
				System.out.println("Block mined, giving: " + textAddress.getText() + " $" + chain.getLastestBlock().miningReward);
	            shell.dispose(); 
			}

			public void widgetDefaultSelected(SelectionEvent e) {}
		});
	}
	
	public static void transactionShell(Display display, BlockChain chain) {
		// FROM HERE WE HAVE THE WINDOW THAT ADDS A TRANSACTION
		
		Shell shell = new Shell(display, SWT.CLOSE);
		shell.setSize(500, 300); 
        shell.setText("Adding Transaction");
		shell.open(); 
		
        Text textFrom = new Text(shell, SWT.NONE);
		textFrom.setText("From........");
		textFrom.setSize(100,25);
		textFrom.setLocation(200,0);
				
		Text textTo = new Text(shell, SWT.NONE);
		textTo.setText("To.............");
		textTo.setSize(100,25);
		textTo.setLocation(200,30);
				
		Text textAmount = new Text(shell, SWT.NONE);
		textAmount.setText("Amount...");
		textAmount.setSize(100,25);
		textAmount.setLocation(200,60);
				
		Button button = new Button(shell, SWT.PUSH);
		button.setText("Add Transaction");
		button.setSize(100,25);
		button.setLocation(350,0);
				
		button.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent event) {       
				Transaction newTrans = new Transaction(textFrom.getText(), textTo.getText(), Long.valueOf(textAmount.getText()));
				System.out.println("Transfer Pending: $" + textAmount.getText() + " from: " +  textFrom.getText() + " to: " + textTo.getText());
				chain.createTransaction(newTrans);
	            shell.dispose(); 
			}

			public void widgetDefaultSelected(SelectionEvent e) {}
		});
		
	}
	
	public static void mainShell() {
		
	}
	
	public static void save(BlockChain chain, String c) {
    	chain.serialiseChain(c);
	}
	
	public static void load(BlockChain chain, String c) {
		chain.deserialiseChain(c);
	}
	
	public static void main(String[] args) {
		
		Display display = new Display();
		Shell shell = new Shell(display, SWT.SHELL_TRIM | SWT.CENTER);
		
		shell.setText("BlockChain");
		shell.setSize(800,600);
		Label label = new Label(shell, SWT.BORDER);
		label.setText("Starting...");
		label.setSize(290,550);
		label.setLocation(5,5);
		
		BlockChain notCoins = new BlockChain(3);
		labelText = notCoins.getLastestBlock().toString();
			
		label.setText(labelText);
		
		// Add Transaction
		Button addAddTransactionsShell = new Button(shell, SWT.NONE);
		addAddTransactionsShell.setText("Add Transaction");
		addAddTransactionsShell.setSize(100,25);
		addAddTransactionsShell.setLocation(300,5);
		addAddTransactionsShell.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent e) {
				labelText = addLine("Adding Transaction...", labelText);
				transactionShell(display, notCoins);
				labelText = addLine("Transaction pending!", labelText);
				label.setText(labelText);
			}

			public void widgetDefaultSelected(SelectionEvent e) {}
		});
		
		// Mining
		Button addMiningShell = new Button(shell, SWT.NONE);
		addMiningShell.setText("Mine");
		addMiningShell.setSize(100,25);
		addMiningShell.setLocation(300,35);
		addMiningShell.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent e) {
				labelText = addLine("Mining Block... Pending transactions proccessing...", labelText);
				miningShell(display, notCoins);
				labelText = addLine("Block Mined!", labelText);
				label.setText(labelText);
			}

			public void widgetDefaultSelected(SelectionEvent e) {}
		});
		
		// Get Balance
		Button addBalanceShell = new Button(shell, SWT.NONE);
		addBalanceShell.setText("Get Balance");
		addBalanceShell.setSize(100,25);
		addBalanceShell.setLocation(300,65);
		addBalanceShell.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent e) {
				labelText = addLine("Getting Balance...", labelText);
				//recentBalance = 0;
				balanceShell(display, notCoins);
				//labelText = addLine("Balance = $" + recentBalance, labelText);
				//recentBalance = 0;
				label.setText(labelText);
			}

			public void widgetDefaultSelected(SelectionEvent e) {}
		});
		
		// Save
		Button saveButton = new Button(shell, SWT.NONE);
		saveButton.setText("Save");
		saveButton.setSize(100,25);
		saveButton.setLocation(300,95);
		saveButton.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent e) {
				save(notCoins, "notCoin");
				labelText = addLine("Saved!", labelText);
				label.setText(labelText);
			}

			public void widgetDefaultSelected(SelectionEvent e) {}
		});
		
		// Load
		Button loadButton = new Button(shell, SWT.NONE);
		loadButton.setText("Load");
		loadButton.setSize(100,25);
		loadButton.setLocation(300,125);
		loadButton.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent e) {
				load(notCoins, "notCoin");
				labelText = addLine("Loaded!", labelText);
				label.setText(labelText);
			}

			public void widgetDefaultSelected(SelectionEvent e) {}
		});
		
		label.setText(labelText);
        
        shell.setBackground(new Color(display, 110, 168, 95));
        
		shell.open();
        while (!shell.isDisposed()) {
        	if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
        display.dispose();
		
	}
}
