package  {
	import flash.display.MovieClip;
	import flash.events.Event;
	import flash.events.TimerEvent;
	import flash.utils.Timer;
	
	public class CREEPER extends MovieClip{
		private var vel: int=5; //velocidad
		private var dir: int=1; //direccionamiento
		//private var b: int=5;
		private var lim_der: int=495; //limite derecho
		private var lim_izq: int=5; //limite izquierdo
		private var t_cambia: Timer = new Timer (200,0);//tiempo de cambio de direccion
		private var dado: int;
		private var t_lanzar: Timer = new Timer (2000,0);//tiempo de fuego, 2000 milisegundos

		public function CREEPER() {
			// constructor
			addEventListener(Event.ENTER_FRAME, actualiza);
			t_cambia.addEventListener(TimerEvent.TIMER, cambia_dir);
			t_cambia.start();
			t_lanzar.addEventListener(TimerEvent.TIMER, lanzar_fuego);
			t_lanzar.start();
		}
		
		function actualiza (e:Event){
			x+=vel*dir;
			if(x>=lim_der){
				dir=-1;
			}
			if(x<=lim_izq){
				dir=1;
			}
			/*if(Setup.puntos==b){
				vel += 20;
				b+=5;
			}*/
		}
		
		function cambia_dir(e: TimerEvent){
			dado=Math.floor(Math.random()*8);
			switch(dado){
				case 1:
				dir=1;
				break;
				case 2:
				dir=-1;
				break;
			}
		}
		
		function lanzar_fuego(e: TimerEvent){
			var Dinamita_new = new DINAMITA(x,y);
			stage.addChild(Dinamita_new);
		}

	}
	
}
