package it.uniroma3.diadia;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;
/**
 * Questa classe modella una partita del gioco
 *
 * @author  docente di POO
 * @see Stanza
 * @version base
 */

public class Partita {
	
	private Labirinto Lab;
	private Giocatore player;
	private boolean finita;
	
	public Partita(Labirinto labirinto) {
		this.Lab=labirinto;
		player=new Giocatore();
		this.finita = false;
	}

	public Labirinto getLabirinto() {
		return Lab;
		
	}
	public void setLabirinto(Labirinto labirinto) {
		this.Lab=labirinto;
	}
	
	public Giocatore getGiocatore() {
		return this.player;
		
	}
	

	
	/**
	 * Restituisce vero se e solo se la partita e' stata vinta
	 * @return vero se partita vinta
	 */
	public boolean vinta() {
		return this.Lab.getStanzaAttuale()== this.Lab.getStanzaFinale();
	}

	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * @return vero se partita finita
	 */
	public boolean isFinita() {
		return finita || vinta() || (player.getCFU() == 0);
	}

	/**
	 * Imposta la partita come finita
	 *
	 */
	public void setFinita() {
		this.finita = true;
	}
	
	public boolean giocatoreVivo() {
		return player.getCFU()>0;
	}
	
	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.getLabirinto().setStanzaAttuale(stanzaCorrente);
	}
	public Stanza getStanzaCorrente() {
		return this.getLabirinto().getStanzaAttuale();
	}

}
