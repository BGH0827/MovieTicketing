package 영화예매;

public class Ticket {
	String id, cinematype, moviename, runningtime, seat;
	int movieprice, person;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCinemaType() {
		return cinematype;
	}
	public void setCinemaType(String cinematype) {
		this.cinematype = cinematype;
	}
	public String getMovieName() {
		return moviename;
	}
	public void setMovieName(String moviename) {
		this.moviename = moviename;
	}
	public String getRunningTime() {
		return runningtime;
	}
	public void setRunningTime(String runningtime) {
		this.runningtime = runningtime;
	}
	public String getSeat() {
		return seat;
	}
	public void setSeat(String seat) {
		this.seat = seat;
	}
	public int getMoviePrice() {
		return movieprice;
	}
	public void setMoviePrice(int movieprice) {
		this.movieprice = movieprice;
	}
	public int getPerson() {
		return person;
	}
	public void setPerson(int person) {
		this.person = person;
	}

}
