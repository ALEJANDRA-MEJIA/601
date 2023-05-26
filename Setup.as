package  {
	import flash.display.MovieClip;
	import flash.events.Event;
	import flash.sampler.NewObjectSample;
	
	public class Setup extends MovieClip{
		private var Fondo_new: FONDOFN = new FONDOFN;
		private var Creeper_new: CREEPER = new CREEPER;
		private var Linea_new: LINEA = new LINEA;
		static var Zombie_new: ZOMBIE = new ZOMBIE;
		static var puntos_contador_new : puntos_contador = new puntos_contador();
		static var puntos : int = 0;

		public function Setup() {
			// constructor
			addChild(Fondo_new);
			addChild(Creeper_new);
			addChild(Zombie_new);
			addChild(Linea_new);
			addChild(puntos_contador_new);
			Fondo_new.x=-2, Fondo_new.y=86;
			Linea_new.x=0, Linea_new.y=100;
			Zombie_new.x=235, Zombie_new.y=280;
			Creeper_new.x=235, Creeper_new.y=10;
		    puntos_contador_new.x=10,puntos_contador_new.y=10;
			puntos_contador_new.Puntos_txt.text = String(puntos);
			this.addEventListener(Event.ENTER_FRAME, actualiza_punto);
		}
		
		public function actualiza_punto(e:Event){
			puntos_contador_new.Puntos_txt.text = String(puntos);
		}

	}
	
}
