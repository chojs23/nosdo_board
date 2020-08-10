package movies;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;



public class MoviesDAO {

		// dao : 데이터베이스 접근 객체의 약자

	

		private Connection conn; // connection:db에접근하게 해주는 객체

		//private PreparedStatement pstmt;

		private ResultSet rs;



		// mysql 처리부분

		public MoviesDAO() {

			// 생성자를 만들어준다.

			try {

				String dbURL = "jdbc:mysql://localhost:3306/NOSDO?serverTimezone=UTC";

				String dbID = "root";

				String dbPassword = "gretrs1!";

				Class.forName("com.mysql.jdbc.Driver");

				conn = DriverManager.getConnection(dbURL, dbID, dbPassword);

			} catch (Exception e) {

				e.printStackTrace();

			}

		}

		

	
			public int getNext() { 

				String SQL = "SELECT number FROM movies ORDER BY number DESC";

				try {

					PreparedStatement pstmt = conn.prepareStatement(SQL);

					rs = pstmt.executeQuery();

					if(rs.next()) {

						return rs.getInt(1) + 1;

					}

					return 1;//첫 번째 게시물인 경우

				} catch (Exception e) {

					e.printStackTrace();

				}

				return -1; //데이터베이스 오류

			}

			

			
			
			public ArrayList<Movies> getList(int pageNumber){ 

				String SQL = "SELECT * FROM movies WHERE number < ? ORDER BY number DESC LIMIT 10";

				ArrayList<Movies> list = new ArrayList<Movies>();
				

				try {

					PreparedStatement pstmt = conn.prepareStatement(SQL);

					pstmt.setInt(1, getNext() - (pageNumber -1) * 10);

					rs = pstmt.executeQuery();

					while (rs.next()) {

						Movies bbs = new Movies();

						bbs.setNumber(rs.getInt(1));

						bbs.setLink(rs.getString(2));
						bbs.setimage(rs.getString(3));
						bbs.settitle(rs.getString(4));

						list.add(bbs);

					}

				} catch (Exception e) {

					e.printStackTrace();

				}

				return list; 

			}

			public boolean nextPage (int pageNumber) {

				String SQL = "SELECT * FROM movies WHERE number < ? ORDER BY number DESC LIMIT 10";

				ArrayList<Movies> list = new ArrayList<Movies>();

				try {

					PreparedStatement pstmt = conn.prepareStatement(SQL);

					pstmt.setInt(1, getNext() - (pageNumber -1) * 10);

					rs = pstmt.executeQuery();

					if (rs.next()) {

						return true;

					}

				} catch (Exception e) {

					e.printStackTrace();

				}

				return false; 		

			}

			public Movies getMovies(int number) {

				String SQL = "SELECT * FROM movies WHERE number = ?";

				try {

					PreparedStatement pstmt = conn.prepareStatement(SQL);

					pstmt.setInt(1, number);

					rs = pstmt.executeQuery();

					if (rs.next()) {

						Movies movies = new Movies();

						movies.setNumber(rs.getInt(1));

						movies.setLink(rs.getString(2));
						movies.setimage(rs.getString(3));
						movies.settitle(rs.getString(4));

						return movies;

					}

				} catch (Exception e) {

					e.printStackTrace();

				}

				return null;



			}
			



	}

