package movies;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;



public class MoviesDAO {

		// dao : �����ͺ��̽� ���� ��ü�� ����

	

		private Connection conn; // connection:db�������ϰ� ���ִ� ��ü

		//private PreparedStatement pstmt;

		private ResultSet rs;



		// mysql ó���κ�

		public MoviesDAO() {

			// �����ڸ� ������ش�.

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

					return 1;//ù ��° �Խù��� ���

				} catch (Exception e) {

					e.printStackTrace();

				}

				return -1; //�����ͺ��̽� ����

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

