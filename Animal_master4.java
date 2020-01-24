import javafx.application.Application;
import javafx.stage.*;  //Stage
import javafx.scene.*;  //Scene
import javafx.scene.control.*;   // Button, Label
import javafx.scene.layout.*;   //BorderPane
import javafx.scene.image.*;
import javafx.scene.input.*;
import javafx.event.*;  //ActionEvent
import javafx.util.Duration;
import javafx.animation.*;


public class Animal_master4 extends Application {
	public Status status = new Status();
	public char character[][] = new char[4][3];
	public ImageView[][] stage_char = new ImageView[4][3];
	public Piece[][] piece = new Piece[4][3];
	public Piece[] mochigoma1 = new Piece[6];
	public Piece[] mochigoma2 = new Piece[6];
  public int previous_i,previous_j;
	public int stock1_size = 0;
	public GridPane gp = new GridPane();
	public Scene scene_title = null;
	//public static Scene scene = new Scene(gp);
	public Scene scene = null;
	public ImageView[] mochigoma1_char = new ImageView[6];
  public ImageView[] mochigoma2_char = new ImageView[6];
	public FlowPane stock_p1 = new FlowPane();
	public FlowPane stock_p2 = new FlowPane();
	public FlowPane shogi_stage = new FlowPane();
	public GridPane shogi_stageH = new GridPane();
  public Button[][] button = new Button[4][3];
	public Button[] mochigoma1_button = new Button[6];
	public Button[] mochigoma2_button = new Button[6];
	public Button[] mochigoma_button = new Button[12];
	public Button button_sub = new Button();
	ImageView char_sub = new ImageView(new Image("non_char_new.png"));


	@Override
	public void start(Stage pstage) {
		Image img_usagi = new Image("Hello.png");//使いまわせる
		Image img_usagi_big = new Image("Hello_big.png");
		ImageView iv = new ImageView(img_usagi);//使いたい度に設定
		Image img_zou = new Image("zou.png");
		Image img_kirin = new Image("kirin.png");
		Image img_hiyoko = new Image("hiyoko.png");
		Image img_lion = new Image("lion.png");
		Image img_non_char = new Image("non_char.png");
		Image img_stock_p1 = new Image("stock_p1.png");
		Image img_stock_p2 = new Image("stock_p2.png");
		setup();//初期設定
		set_position();//コマの配置
		setup_stock();
		repaint();


		for(int i = 0;i < 4;i++){
			for(int j = 0;j < 3;j++){
				button[i][j] = new Button("",stage_char[i][j]);
				button[i][j].setMaxHeight(180);
				button[i][j].setMaxWidth(180);
				//button[i][j].setStyle("-fx-background-color: #ffffff");
			}
			shogi_stageH.addRow(i,button[i][0],button[i][1],button[i][2]);
		}

		button_sub = new Button("",char_sub);
		//gp.add(button_sub,0,1,1,1);
	  shogi_stageH.setMaxWidth(550);
	  //shogi_stageH.setPrefWrapLength(550);





	  stock_p1.setMinHeight(400);
	  stock_p1.setPrefWrapLength(550);
	  set_position_stock1();
	  for(int i = 0;i < 6;i++){
	 	 mochigoma1_button[i] = new Button("",mochigoma1_char[i]);
		 mochigoma1_button[i].setMaxHeight(180);
		 mochigoma1_button[i].setMaxWidth(180);
		 stock_p1.getChildren().add(mochigoma1_button[i]);
	  }


	  stock_p2.setMinHeight(360);
		stock_p2.setMaxHeight(360);
	  stock_p2.setMinWidth(540);
	  stock_p2.setPrefWrapLength(540);
	  set_position_stock2();
	  for(int i = 0;i < 6;i++){
	 	 mochigoma2_button[i] = new Button("",mochigoma2_char[i]);
		 mochigoma2_button[i].setMaxHeight(180);
		 mochigoma2_button[i].setMaxWidth(180);
	 	 stock_p2.getChildren().add(mochigoma2_button[i]);
	  }

 	 for(int size = stock1_size;size < 6;size++){
 		 mochigoma1_button[size].setStyle("-fx-background-color: #ff000000");
 	 }

	  Label time_p1 = new Label("0:00");
	  Label time_p2 = new Label("0:00");
	  //Label space = new Label("           ");

	  gp.addRow(0,time_p1,time_p2);
	  gp.add(shogi_stageH,1,1,3,2);
	  stock_p1.setStyle("-fx-background-color: #ff0000");
	  stock_p2.setStyle("-fx-background-color: #66cdaa");
		//gp.add(button[0][1],0,1,1,1);
		//下２行入れる
		gp.add(stock_p1,4,2,1,1);
		gp.add(stock_p2,0,1,1,1);

		//gp.add(space,3,1,1,2);
	  //画面描画終わり

		//タイトル画面
		Button title = new Button("start");

		initTitle(pstage);
		initScene(pstage);

		pstage.setScene(scene_title); //ステージ(ウィンドウ)にシーンを入れる
		pstage.setTitle("Helllllo"); //ウィンドウタイトルの設定
		pstage.sizeToScene();  //ウィンドウサイズをシーンに合わせる
		pstage.show();  //ウィンドウを表示
		//パンドラの匣
		EventHandler<MouseEvent> h= (event) -> {//EventHandler
			for(int i = 0;i < 4; i++){
				for(int j = 0;j < 3; j++){
					if(event.getSource() == button[i][j]){
						clickPiece(status,piece,i,j);
						System.out.println("pressed");
					}
				}
			}
		};
		EventHandler<MouseEvent> h1=(event) ->{
			for(int i = 0; i < 6; i++){
				if(event.getSource() == mochigoma1_button[i]){
					clickStock(status, mochigoma1,i);
				}
				else if(event.getSource() == mochigoma2_button[i]){
					clickStock(status,mochigoma2,i);
				}
			}
		};

		EventHandler<MouseEvent> h2=(event) ->{
			for(int i = 0;i < 4; i++){
				for(int j = 0;j < 3; j++){
					if(event.getSource() == button[i][j]){
						EnteredPiece(status,piece,i,j);
						previous_i = i;
						previous_j = j;
					}
				}
			}
		};

		EventHandler<MouseEvent> h3=(event) ->{
			button[previous_i][previous_j].setStyle("");
		};

		for(int i = 0;i < 6;i++){
			mochigoma1_button[i].setOnMousePressed(h1);
			mochigoma2_button[i].setOnMousePressed(h1);
		}

		for(int i = 0;i < 4;i++){
			for(int j = 0;j < 3;j++){
				button[i][j].setOnMousePressed(h);
				button[i][j].setOnMouseEntered(h2);
				button[i][j].setOnMouseExited(h3);
				}
			}
		}

	//ここから関数
	public void setup(){	//初期設定
		//public Piece[][] piece;
		for(int i = 0;i<4;i++){
			for(int j = 0;j<3;j++){
				if(((i == 3)&&(j == 2))){
						piece[i][j] = new Zou(1);
				}
				else if(((i == 3)&&(j == 1))){
						piece[i][j] = new Lion(1);
				}
				else if(((i == 3)&&(j == 0))){
						piece[i][j] = new Kirin(1);
				}
				else if(((i == 2)&&(j == 1))){
						piece[i][j] = new Hiyoko(1);
				}
				else if(((i == 0)&&(j == 0))){
						piece[i][j] = new Zou(2);
				}
				else if(((i == 0)&& (j == 1))){
						piece[i][j] = new Lion(2);
				}
				else if(((i == 0)&& (j == 2))){
						piece[i][j] = new Kirin(2);
				}
				else if(((i == 1)&& (j == 1))){
						piece[i][j] = new Hiyoko(2);
				}
				else{
						piece[i][j] = new NonChar();
				}
			}
		}
	}

 public void set_position(){
	for(int i = 0;i<4;i++){//場所を決める
		for(int j = 0;j<3;j++){
				stage_char[i][j] = new ImageView(piece[i][j].image);
		}
	}
}


public void change(double X,double Y){
		System.out.println(X+","+Y);
		set_position();
}

 public void initTitle(Stage pstage){
	 AnchorPane root = new AnchorPane();
	 Group groot = new Group();
	 scene_title = new Scene(root);

	 //Button title = new Button("",new ImageView(new Image("startpage.png")));
	 groot.setOnMouseClicked(event -> setScene(pstage,scene));
	 Button title1 = new Button("",new ImageView(new Image("startpage_whiteAndBOMRAD.png")));
	 Button title2= new Button("",new ImageView(new Image("startpage.png")));
	 FadeTransition fadeTransition   = new FadeTransition();
	 FadeTransition fadeTransition2   = new FadeTransition();
	 FadeTransition fadeTransition3   = new FadeTransition();
	 fadeTransition3.setNode(title2);
	 fadeTransition3.setFromValue(0);
	 fadeTransition3.play();
   fadeTransition.setNode(title1);
	 fadeTransition.setFromValue(0);
	 fadeTransition.setToValue(1);
	 fadeTransition.setDuration(Duration.millis(5000));
	 fadeTransition.setAutoReverse(false);
	 fadeTransition.play();

	 EventHandler<ActionEvent> h4= (event) -> {//EventHandler
		 fadeTransition.stop();
		 fadeTransition2.setNode(title1);
		 fadeTransition2.setDuration(Duration.millis(5000));
		 fadeTransition2.setFromValue(1);
		 fadeTransition2.setToValue(0);
		 fadeTransition2.setAutoReverse(false);
		 fadeTransition2.play();
	 };
	 EventHandler<ActionEvent> h5= (event) -> {//EventHandler
			groot.getChildren().remove(title1);
			fadeTransition3.setNode(title2);
			fadeTransition3.setDuration(Duration.millis(5000));
			//fadeTransition3.setFromValue(0);
			fadeTransition3.setToValue(1);
			fadeTransition3.setAutoReverse(false);
			fadeTransition3.play();
			//groot.getChildren().add(title2);
	 };

	 fadeTransition.setOnFinished(h4);
	 fadeTransition2.setOnFinished(h5);
	 title2.setOnMouseClicked(event -> setScene(pstage,scene));
	 root.getChildren().add(groot);
	 groot.getChildren().addAll(title1,title2);
 }

 public void initScene(Stage pstage){
	 scene = new Scene(gp);
 }

 public void setScene(Stage stage,Scene changeScene){
	 stage.setScene(changeScene);
	 stage.show();
 }

 public void set_position_stock1(){
	 for(int i = 0;i < 6;i++){
		 	mochigoma1_char[i] = new ImageView(mochigoma1[i].image);
	 }
 }

 public void set_position_stock2(){
	 for(int i = 0;i < 6;i++){
	 	  mochigoma2_char[i] = new ImageView(mochigoma2[i].image);
	 }
 }

 public void setup_stock(){
	 for(int i = 0;i < 6;i++){
		 	mochigoma1[i] = new NonChar();
			mochigoma2[i] = new NonChar();
	 }
 }

 public void clickPiece(Status status, Piece[][] piece,int i,int j){
	 char_sub.setImage(stage_char[i][j].getImage());

	 System.out.println("("+j+","+i+")");
	 int currentX = j;
	 int currentY = i;
	 int[][] pieceDirect = new int[4][3];

	 Image img_non_char = new Image("non_char_new.png");
	 if(status.selected == 0){
		 if(piece[currentY][currentX].forf == status.player){
			 status.X = currentX;
			 status.Y = currentY;
			 status.selected = 1;
		 }
	 }
	 else{
		 if(piece[currentY][currentX].forf == status.player){
			 status.X = currentX;
			 status.Y = currentY;
		 }
		 else{
			 status.toX = currentX;
			 status.toY = currentY;
			 if(piece[status.Y][status.X].canMovePiece(piece[status.Y][status.X].forf, status.X, status.Y, status.toX, status.toY) == 1){
				 if(piece[status.toY][status.toX].forf != 0){

				 }
				 stage_char[status.toY][status.toX].setImage(piece[status.Y][status.X].image);
				 stage_char[status.Y][status.X].setImage(img_non_char);
				 System.out.println(piece[status.Y][status.X].forf+","+piece[status.toY][status.toX].forf+"状況："+piece[status.Y][status.X].forf+"の"+piece[status.Y][status.X].animal+"が"+piece[status.toY][status.toX].forf+"の"+piece[status.toY][status.toX].animal+"を取った。");
				 piece[status.toY][status.toX] = piece[status.Y][status.X];
				 System.out.println(piece[status.Y][status.X].forf+","+piece[status.toY][status.toX].forf);
				 piece[status.Y][status.X] = new NonChar();
				 System.out.println(piece[status.Y][status.X].forf+","+piece[status.toY][status.toX].forf);
				 status.selected=0;
				 if(status.player == 1){
					 status.player = 2;
				 }
				 else{
					 status.player = 1;
				 }
			 }
		 }
	 }
	 if(piece[currentY][currentX].forf == status.player){
		 pieceDirect = piece[currentY][currentX].canGoDirect(currentX, currentY,piece);
		 for(int k=0; k<4; k++){
			for(int l=0; l<3; l++){
				System.out.println(pieceDirect[k][l]+",");
				button[k][l].setStyle("");
				if(pieceDirect[k][l] == 1){
					if(status.player == 1){
							button[k][l].setStyle("-fx-background-color: #ff0000");
					}
					else if(status.player == 2){
							button[k][l].setStyle("-fx-background-color: #0000ff");
					}
				}
			}
		}
	 }

	 System.out.println("現在地:"+status.X+","+status.Y+","+piece[status.Y][status.X].forf+", 目的地:"+status.toX+","+status.toY+","+piece[status.toY][status.toX].forf);
	 System.out.println("selected:"+status.selected+", player:"+status.player);

 }

 public void EnteredPiece(Status status, Piece[][] piece,int i,int j){

	int currentX = j;
	int currentY = i;

	if(status.player == 1){
			button[currentY][currentX].setStyle("-fx-background-color: #ff0000");
	}
	else if(status.player == 2){
			button[currentY][currentX].setStyle("-fx-background-color: #0000ff");
	}
}

 public void clickStock(Status status, Piece[] mochigoma,int i){
	 	System.out.println("i:"+i);
		for(int size = stock1_size;size < 6;size++){
 		 mochigoma1_button[size].setStyle("-fx-background-color: #ff000000");
 	 }
 }
 public void repaint(){
	 //画面描画のところ

 }


	public static void main(String[] args) {
		launch(args);
	}
}
