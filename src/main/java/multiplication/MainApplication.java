package multiplication;

import multiplication.controller.MultipliesController;

public class MainApplication {

	public static void main(String[] args){
		MultipliesController multiplyController = new MultipliesController();
		multiplyController.run();
	}
}
