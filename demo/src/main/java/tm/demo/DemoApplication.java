package tm.demo;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.*;

@Slf4j
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

		Connection c = null;
		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/market", "postgres", "root");


			topClientesFacturas(c);
			topClientesGasto(c);
			topMonedas(c);
			topProveedor(c);
//			topProductos(c);

		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Opened database successfully");
	}


	public static void topClientesFacturas(Connection c) throws SQLException {
		try (Statement stmt = c.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT c.nombre || ' ' || c.apellido AS CLIENTE, " +
					 "COUNT(f.cliente_id) AS CANTIDAD_FACTURAS " +
					 "FROM factura f " +
					 "JOIN cliente c ON c.id = f.cliente_id " +
					 "GROUP BY c.nombre, c.apellido " +
					 "ORDER BY COUNT(f.cliente_id) DESC;")) {
			while (rs.next()) {
				System.out.println("Cliente: " + rs.getString("CLIENTE") +
						", Cantidad de Facturas: " + rs.getInt("CANTIDAD_FACTURAS"));
			}
		}
	}

	public static void topClientesGasto(Connection c) throws SQLException {
		try (Statement stmt = c.createStatement();
			 ResultSet rs = stmt.executeQuery(
					 "select c.nombre || ' ' || c.apellido AS CLIENTE , sum (p.precio * fd.cantidad) AS MONTO\n" +
							 "from cliente c\n" +
							 "join factura f on f.cliente_id = c.id\n" +
							 "join factura_detalle fd on fd.factura_id = f.id\n" +
							 "join producto p on p.id = fd.producto_id\n" +
							 "group by c.nombre || ' ' || c.apellido\n" +
							 "order by monto desc\n" +
							 "limit 5"
			 )) {
			while (rs.next()) {
				System.out.println("Cliente: " + rs.getString("CLIENTE") +
						", Monto: " + rs.getInt("MONTO"));
			}
		}
	}
	public static void topMonedas (Connection c) throws SQLException {
		try (Statement stmt = c.createStatement();
			 ResultSet rs = stmt.executeQuery(
					 "select c.nombre || ' ' || c.apellido AS CLIENTE , sum (p.precio * fd.cantidad) AS MONTO\n" +
							 "from cliente c\n" +
							 "join factura f on f.cliente_id = c.id\n" +
							 "join factura_detalle fd on fd.factura_id = f.id\n" +
							 "join producto p on p.id = fd.producto_id\n" +
							 "group by c.nombre || ' ' || c.apellido\n" +
							 "order by monto desc\n" +
							 "limit 5"
			 )) {
			while (rs.next()) {
				System.out.println("Cliente: " + rs.getString("CLIENTE") +
						", Monto: " + rs.getInt("MONTO"));
			}
		}
	}
	public static void topProveedor (Connection c) throws SQLException {
		try (Statement stmt = c.createStatement();
			 ResultSet rs = stmt.executeQuery(
					 "select pv.nombre, count (pd.id) cantidad\n" +
							 "from proveedor pv, producto pd\n" +
							 "where pd.proveedor_id = pv.id\n" +
							 "group by pv.nombre, pv.ruc\n" +
							 "order by cantidad desc\n" +
							 "limit 5"
			 )) {
			while (rs.next()) {
				System.out.println("Proveedor: " + rs.getString("nombre") +
						", Monto: " + rs.getInt("cantidad"));
			}
		}
	}

	public static void topProductos (Connection c) throws SQLException {
		try (Statement stmt = c.createStatement();
			 ResultSet rs = stmt.executeQuery(
					 "select pd.nombre, sum (fd.cantidad) cantidad\n" +
							 "from producto pd, factura_detalle fd\n" +
							 "where fd.producto_id = pd.id\n" +
							 "group by pd.nombre\n" +
							 "order by cantidad desc\n" +
							 "limit 5"
			 )) {
			while (rs.next()) {
				System.out.println("Producto: " + rs.getString("nombre") +
						", Cantidad: " + rs.getInt("cantidad"));
			}
		}
	}
}

