import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.input.Controller;
import org.lwjgl.input.Controllers;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.GL11;

public class SampleGame {

    private Controller control;

    public void start() {
        // ������
        initialize();
        // �Q�[�����[�v
        gameLoop();
        // �I������
        destroy();
    }
	
    /*
     * ������
     */
    public void initialize() {
        // �f�B�X�v���C���[�h�̐ݒ�
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
        
        // �ڑ�����Ă���R���g���[�����擾�E������
        try {
            Controllers.create();
        } catch (LWJGLException e) {
            e.printStackTrace();
        }
        // �ڑ�����Ă���R���g���[���̒������̃C���X�^���X���擾
        // ����͈�����Q�[���p�b�h���Ȃ��Ƃ����O��ň���0
        control = Controllers.getController(0);
        
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glDisable(GL11.GL_DEPTH_TEST);
        GL11.glMatrixMode(GL11.GL_PROJECTION);
        GL11.glLoadIdentity();

        GL11.glOrtho(0, 640, 480, 0, -1, 1);

        GL11.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        
    }
    
    /*
     * �I������
     */	
    public void destroy() {
        Display.destroy();	
    }
	
    /*
     * �Q�[�����[�v
     */
    public void gameLoop() {
        while(!Display.isCloseRequested()) {
            
            Display.update();
            // �R���g���[���̓��͏����X�V
            control.poll();
            
            // �`��
            render();
            
            // �{�^���������ꂽ���`�F�b�N
            if(control.isButtonPressed(0)) {
                System.out.println("0�F�l�p��");
            }
            if(control.isButtonPressed(1)) {
                System.out.println("1�F�H");
            }
            if(control.isButtonPressed(2)) {
                System.out.println("2�F�H");
            }
            if(control.isButtonPressed(3)) {
                System.out.println("3�F�H");
            }
            if(control.isButtonPressed(4)) {
                System.out.println("4�F�H");
            }
            if(control.isButtonPressed(5)) {
                System.out.println("5�F�H");
            }
            if(control.isButtonPressed(6)) {
                System.out.println("6�F�H");
            }
            if(control.isButtonPressed(7)) {
                System.out.println("7�F�H");
            }
            if(control.isButtonPressed(8)) {
                System.out.println("8�F�H");
            }
            if(control.isButtonPressed(9)) {
                System.out.println("9�F�H");
            }
            if(control.isButtonPressed(10)) {
                System.out.println("10�F�H");
            }
            if(control.isButtonPressed(11)) {
                System.out.println("11�F�H");
            }
           
            float    xAxis = control.getXAxisValue();
	        float    yAxis = control.getYAxisValue();
	 
	        //    �A�i���O�X�e�B�b�N�� X �������̓��͏�Ԃ𔽉f����
	        boolean    isLeftPressing = false;
	        boolean    isRightPressing = false;
	        if (xAxis < 0) {
	            isLeftPressing = true;
	            System.out.println("��");
	        } else if (0 < xAxis) {
	            isRightPressing = true;
	            System.out.println("�E");
	        }
	        	 
	        //    �A�i���O�X�e�B�b�N�� Y �������̓��͏�Ԃ𔽉f����
	        boolean    isUpPressing = false;
	        boolean    isDownPressing = false;
	        if (yAxis < 0) {
	            isUpPressing = true;
	            System.out.println("��");
	        } else if (0 < yAxis) {
	            isDownPressing = true;
	            System.out.println("��");
	        }
	    }
            Display.sync(60);
        }
    

	/*
	 * �`�揈��
	 */
	public void render() {
        GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
    }

    /*
     * ���C��
     */
    public static void main(String args[]) {
        SampleGame game = new SampleGame();
        game.start();
    }
}