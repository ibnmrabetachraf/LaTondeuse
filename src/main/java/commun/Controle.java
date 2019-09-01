package commun;

import beans.Tondeuse;

/**
 * Classe enum représente les différents mouvement de rotation et d'avancement d'une tondeuse
 * @author ibn
 *
 */
public enum Controle {

	D // tourner vers la droite
	{
		@Override
		public void execute(Tondeuse tondeuse) {
			tondeuse.goDroite();

		}
	}	,
	G // tourner vers la gauche
	{
		@Override
		public void execute(Tondeuse tondeuse) {
			tondeuse.goGauche();

		}
	},	
	A // Avancer

	{
		@Override
		public void execute(Tondeuse tondeuse){
			tondeuse.avancer();

		}
	}	;

	public abstract void execute(Tondeuse tondeuse);
}
