package  {
	import flash.display.MovieClip;
	import flash.events.Event;
	import flash.events.KeyboardEvent;
	
	public class ZOMBIE extends MovieClip{
		private var der: Boolean = false;
		private var izq: Boolean = false;
		private var vel: int=10;

		public function ZOMBIE() {
			// constructor
			addEventListener(Event.ENTER_FRAME, motor);
		}
		
		function motor(e:Event): void{
			if(der){
			x+=10;
			} 
			else if(izq){
			x-=10;
			}
			
			//Deje de avanzar
			if(x>=495){
			x-=10;
			}
			if(x<=-5){
			x+=10;
			}
			
			controles();
		}
		
		function controles(){
			stage.addEventListener(KeyboardEvent.KEY_DOWN, keydown);
			stage.addEventListener(KeyboardEvent.KEY_UP, keyup);
		}
		
		function keydown(e:KeyboardEvent): void{
			switch(e.keyCode){
				//tecla D en ASCCI: 68
				//tecla -> en ASCCI: 39
				//tecla A en ASCCI: 65
				//tecla <- en ASCCI: 37
				
				case 68:
				der = true; 
				break;
				case 65:
				izq = true; 
				break;
				
				case 39:
				der = true;
				break;
				case 37:
				izq = true;
				break;
			}
		}
		
		function keyup(e:KeyboardEvent): void{
			switch(e.keyCode){
				//tecla D en ASCCI: 68
				//tecla -> en ASCCI: 39
				//tecla A en ASCCI: 65
				//tecla <- en ASCCI: 37
				
				case 68:
				der = false; 
				break;
				case 65:
				izq = false; 
				break;
				
				case 39:
				der = false;
				break;
				case 37:
				izq = false;
				break;
			}
		}
	}
}
