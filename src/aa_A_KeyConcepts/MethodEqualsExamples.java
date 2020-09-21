package aa_A_KeyConcepts;

public class MethodEqualsExamples {
	
	// equlas Vergelich(WennKeineDefiniert,R:true wenn Aliase
	// überprüft mit umgeschriebener equals Methode ob die 
	// CardNumber gleich sind ( mit primitivem Datentyp)
	public boolean equals(PlayerCard otherCard) {
		return (this.cardNumber == otherCard.getCardNumber());
	}
	// überprüft mit umgeschriebener Methode ob die 
	// PlayerName gleich sind (mit String)
	public boolean equals2(PlayerCard otherCard) {
		if(this.playerName.equals(otherCard.getPlayerName())) {
			return true;
	}
		return false;
	}
	// überprüft mit umgeschriebener equals Methode ob die 
	// CardNumber && PlayerName gleich sind (Ganzes Objekt)
	public boolean equals3(PlayerCard otherCard) {
		if(this.playerName.equals(otherCard.getPlayerName()) &&
			this.cardNumber == otherCard.getCardNumber()){
			return true;
		}
		return false;
	}


}
