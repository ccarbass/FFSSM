/**
 * @(#) Site.java
 */

package FFSSM;

public class Site
{
	public String nom;
	private String details;

	public Site(String nom, String details) {
		this.nom = nom;
		this.details = details;
	}



	@Override
	public String toString() {
		return "Site{" + "nom: " + nom + ", details:  " + details + '}';
	}

	
}
