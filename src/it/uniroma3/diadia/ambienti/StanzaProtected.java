package it.uniroma3.diadia.ambienti;
import it.uniroma3.diadia.attrezzi.*;

public class StanzaProtected {
	static final private int MAX_DIREZIONI= 4;
	protected static final int MAX_ATTREZZI= 10;
	
	public String nome;
	protected Attrezzo[] attrezzi;
	protected int numeroAttrezzi;
	
	public int getAttrezziRimanenti() {
		return MAX_ATTREZZI-this.numeroAttrezzi;
	}
	
	
	protected StanzaProtected[] stanzeAdiacenti;
	protected int numerostanzeAdiacenti;
	protected String[] direzioni;
	
	
	
	public StanzaProtected(String nome) {
		this.nome=nome;
		this.numerostanzeAdiacenti=0;
		this.numeroAttrezzi=0;
		this.direzioni=new String[MAX_DIREZIONI];
		this.stanzeAdiacenti=new StanzaProtected[MAX_DIREZIONI];
		this.attrezzi=new Attrezzo[MAX_ATTREZZI];
	}
	
	/**
	 * Imposta una stanza adiacente.
	 *
	 * @param direzione direzione in cui sara' posta la stanza adiacente.
	 * @param stanza stanza adiacente nella direzione indicata dal primo parametro.
	 */
	public void impostaStanzaAdiacente(String direzione, StanzaProtected stanza) {
		boolean aggiornato = false;
		for(int i=0; i<this.direzioni.length; i++)
			if (direzione.equals(this.direzioni[i])) {
				this.stanzeAdiacenti[i] = stanza;
				aggiornato = true;
			}
		if (!aggiornato)
			if (this.numerostanzeAdiacenti < MAX_DIREZIONI) {
				this.direzioni[numerostanzeAdiacenti] = direzione;
				this.stanzeAdiacenti[numerostanzeAdiacenti] = stanza;
				this.numerostanzeAdiacenti++;
			}
	}

	/**
	 * Restituisce la stanza adiacente nella direzione specificata
	 * @param direzione
	 */
	public StanzaProtected getStanzaAdiacente(String direzione) {
		StanzaProtected stanza = null;
		for(int i=0; i<this.numerostanzeAdiacenti; i++)
			if (this.direzioni[i].equals(direzione))
				stanza = this.stanzeAdiacenti[i];
		return stanza;
	}

	/**
	 * Restituisce la nome della stanza.
	 * @return il nome della stanza
	 */
	public String getNome() {
		return this.nome;
	}

	/**
	 * Restituisce la descrizione della stanza.
	 * @return la descrizione della stanza
	 */
	public String getDescrizione() {
		return this.toString();
	}

	/**
	 * Restituisce la collezione di attrezzi presenti nella stanza.
	 * @return la collezione di attrezzi nella stanza.
	 */
	public Attrezzo[] getAttrezzi() {
		return this.attrezzi;
	}

	/**
	 * Mette un attrezzo nella stanza.
	 * @param attrezzo l'attrezzo da mettere nella stanza.
	 * @return true se riesce ad aggiungere l'attrezzo, false atrimenti.
	 */
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (this.numeroAttrezzi < MAX_ATTREZZI) {
			this.attrezzi[numeroAttrezzi] = attrezzo;
			this.numeroAttrezzi++;
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Restituisce una rappresentazione stringa di questa stanza,
	 * stampadone la descrizione, le uscite e gli eventuali attrezzi contenuti
	 * @return la rappresentazione stringa
	 */
	public String toString() {
		StringBuilder risultato = new StringBuilder();
		risultato.append(this.nome);
		risultato.append("\nUscite: ");
		for (String direzione : this.direzioni)
			if (direzione!=null)
				risultato.append(" " + direzione);
		risultato.append("\nAttrezzi nella stanza: ");
		for (Attrezzo attrezzo : this.attrezzi) {
			if(attrezzo!=null)
				risultato.append(attrezzo.toString()+" ");
		}
		return risultato.toString();
	}

	/**
	 * Controlla se un attrezzo esiste nella stanza (uguaglianza sul nome).
	 * @return true se l'attrezzo esiste nella stanza, false altrimenti.
	 */
	public boolean hasAttrezzo(String nomeAttrezzo) {
		boolean trovato;
		trovato = false;
		for (Attrezzo attrezzo : this.attrezzi) {
			if(attrezzo != null) {
				if (attrezzo.getNome().equals(nomeAttrezzo))
					trovato = true;
			}
		}
		return trovato;
	}

	/**
	 * Restituisce l'attrezzo nomeAttrezzo se presente nella stanza.
	 * @param nomeAttrezzo
	 * @return l'attrezzo presente nella stanza.
	 * 		   null se l'attrezzo non e' presente.
	 */
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo attrezzoCercato;
		attrezzoCercato = null;
		for (Attrezzo attrezzo : this.attrezzi) {
			if(attrezzo != null)
				if (attrezzo.getNome().equals(nomeAttrezzo))
					attrezzoCercato = attrezzo;
		}
		return attrezzoCercato;	
	}

	/**
	 * Rimuove un attrezzo dalla stanza (ricerca in base al nome).
	 * @param nomeAttrezzo
	 * @return true se l'attrezzo e' stato rimosso, false altrimenti
	 */
	public boolean removeAttrezzo(Attrezzo attrezzo) {
		if(attrezzo!=null){
			int i = 0;
			for(Attrezzo a : this.attrezzi) {
				if(a != null) {
					if(a.getNome().equals(attrezzo.getNome())) {
						this.attrezzi[i] = null;
						this.numeroAttrezzi--;
					}
				}
				i++;

			}
			return true;
		}
		else
			return false;
	}


	public String[] getDirezioni() {
		String[] direzioni = new String[this.numerostanzeAdiacenti];
		for(int i=0; i<this.numerostanzeAdiacenti; i++)
			direzioni[i] = this.direzioni[i];
		return direzioni;
	}

}
