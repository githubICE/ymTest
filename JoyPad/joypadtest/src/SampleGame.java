import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.input.Controller;
import org.lwjgl.input.Controllers;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.GL11;

public class SampleGame {

    private Controller control;

    public void start() {
        // 初期化
        initialize();
        // ゲームループ
        gameLoop();
        // 終了処理
        destroy();
    }
	
    /*
     * 初期化
     */
    public void initialize() {
        // ディスプレイモードの設定
        try {
            DisplayMode[] mode = org.lwjgl.util.Display.getAvailableDisplayModes(640, 480, -1, -1, -1, -1, 60, 60);
            org.lwjgl.util.Display.setDisplayMode(mode, new String[] {
                           "width=" + 640,
                           "height=" + 480,
                           "freq=" + 60,
                           "bpp=" + Display.getDisplayMode().getBitsPerPixel() 
                          });
            Display.setFullscreen(false);
            Display.create();
            Display.setTitle("SampleGame");
        } catch(Exception e) {
            e.printStackTrace();
        }
        
        // 接続されているコントローラを取得・初期化
        try {
            Controllers.create();
        } catch (LWJGLException e) {
            e.printStackTrace();
        }
        // 接続されているコントローラの中から一つのインスタンスを取得
        // 今回は一つしかゲームパッドがないという前提で引数0
        control = Controllers.getController(0);
        
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glDisable(GL11.GL_DEPTH_TEST);
        GL11.glMatrixMode(GL11.GL_PROJECTION);
        GL11.glLoadIdentity();

        GL11.glOrtho(0, 640, 480, 0, -1, 1);

        GL11.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        
    }
    
    /*
     * 終了処理
     */	
    public void destroy() {
        Display.destroy();	
    }
	
    /*
     * ゲームループ
     */
    public void gameLoop() {
        while(!Display.isCloseRequested()) {
            
            Display.update();
            // コントローラの入力情報を更新
            control.poll();
            
            // 描画
            render();
            
            // ボタンが押されたかチェック
            if(control.isButtonPressed(0)) {
                System.out.println("0：四角い");
            }
            if(control.isButtonPressed(1)) {
                System.out.println("1：？");
            }
            if(control.isButtonPressed(2)) {
                System.out.println("2：？");
            }
            if(control.isButtonPressed(3)) {
                System.out.println("3：？");
            }
            if(control.isButtonPressed(4)) {
                System.out.println("4：？");
            }
            if(control.isButtonPressed(5)) {
                System.out.println("5：？");
            }
            if(control.isButtonPressed(6)) {
                System.out.println("6：？");
            }
            if(control.isButtonPressed(7)) {
                System.out.println("7：？");
            }
            if(control.isButtonPressed(8)) {
                System.out.println("8：？");
            }
            if(control.isButtonPressed(9)) {
                System.out.println("9：？");
            }
            if(control.isButtonPressed(10)) {
                System.out.println("10：？");
            }
            if(control.isButtonPressed(11)) {
                System.out.println("11：？");
            }
           
            float    xAxis = control.getXAxisValue();
	        float    yAxis = control.getYAxisValue();
	 
	        //    アナログスティックの X 軸方向の入力状態を反映する
	        boolean    isLeftPressing = false;
	        boolean    isRightPressing = false;
	        if (xAxis < 0) {
	            isLeftPressing = true;
	            System.out.println("左");
	        } else if (0 < xAxis) {
	            isRightPressing = true;
	            System.out.println("右");
	        }
	        	 
	        //    アナログスティックの Y 軸方向の入力状態を反映する
	        boolean    isUpPressing = false;
	        boolean    isDownPressing = false;
	        if (yAxis < 0) {
	            isUpPressing = true;
	            System.out.println("上");
	        } else if (0 < yAxis) {
	            isDownPressing = true;
	            System.out.println("下");
	        }
	    }
            Display.sync(60);
        }
    

	/*
	 * 描画処理
	 */
	public void render() {
        GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
    }

    /*
     * メイン
     */
    public static void main(String args[]) {
        SampleGame game = new SampleGame();
        game.start();
    }
}