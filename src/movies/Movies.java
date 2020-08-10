package movies;

import java.util.ArrayList;

public class Movies {

	ArrayList<String> slist = new ArrayList<String>();
	
	private String link;
	private String image;
	private int number;
	private String title;

	
	public int getNumber() {

		return number;

	}

	public void setNumber(int number) {

		this.number = number;

	}

	public String getLink() {

		return link;

	}

	public void setLink(String link) {

		this.link = link;

	}
	
	public String getimage() {

		return image;

	}

	public void setimage(String image) {

		this.image = image;

	}
	public String gettitle() {

		return title;

	}

	public void settitle(String title) {

		this.title = title;

	}

}
