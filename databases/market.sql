
--Top clientes con mas facturas:

select c.nombre || ' ' || c.apellido CLIENTES , count (f.id) "CANTIDAD FACTURA"
from cliente c
join factura f on f.cliente_id = c.id 
group by c.nombre, c.apellido
order by "CANTIDAD FACTURA" desc
limit 5

--Top clientes que mas gastaron:

select c.nombre || ' ' || c.apellido CLIENTES , sum (p.precio * fd.cantidad) monto
from cliente c
join factura f on f.cliente_id = c.id
join factura_detalle fd on fd.factura_id = f.id
join producto p on p.id = fd.producto_id
group by c.nombre || ' ' || c.apellido
order by monto desc
limit 5

--Top monedas más utilizadas:

select m.nombre, count (f.id) cantidad
from moneda m, factura f
where f.moneda_id = m.id
group by m.nombre
order by cantidad desc
limit 5

--Top proveedor de productos:

select pv.nombre, count (pd.id) cantidad
from proveedor pv, producto pd
where pd.proveedor_id = pv.id
group by pv.nombre, pv.ruc
order by cantidad desc
limit 5

-Productos más vendidos:

select pd.nombre, sum (fd.cantidad) cantidad
from producto pd, factura_detalle fd
where fd.producto_id = pd.id
group by pd.nombre
order by cantidad desc
limit 5

--Productos menos vendidos:

select pd.nombre, sum (fd.cantidad) cantidad
from producto pd, factura_detalle fd
where fd.producto_id = pd.id
group by pd.nombre
order by cantidad asc
limit 5


-- Consulta que muestra fecha de emisión de factura, nombre y apellido del cliente,
-- nombres de productos de esa factura, cantidades compradas,
-- nombre de tipo de factura de una factura específica
--Probamos con la factura_id = 97

select f.fecha_emision, c.nombre || ' ' || c.apellido cliente,
pd.nombre, fd.cantidad, ft.nombre
from cliente c 
join factura f on f.cliente_id = c.id
join factura_tipo ft on f.factura_tipo_id = ft.id
join factura_detalle fd on fd.factura_id = f.id
join producto pd on fd.producto_id = pd.id
where fd.factura_id = 97
---------------------------------------------------------------
select factura.fecha_emision, cliente.nombre || ' ' || cliente.apellido cliente,
producto.nombre, factura_detalle.cantidad, factura_tipo.nombre
from cliente ,factura, factura_tipo, factura_detalle, producto
where factura.cliente_id = cliente.id
and factura.factura_tipo_id = factura_tipo.id
and factura_detalle.factura_id = factura.id
and factura_detalle.producto_id = producto.id
and factura_detalle.factura_id = 97

-- Montos de facturas ordenados según totales
-- Mostrar el IVA del 10% de los montos totales de facturas
-- (suponer que todos los productos tienen IVA del 10%)

select f.id, 
sum (p.precio * fd.cantidad) totales, 
sum(p.precio * fd.cantidad * 0.1) iva
from factura f, producto p, factura_detalle fd
where f.id = fd.factura_id 
and fd.producto_id = p.id
group by f.id
order by totales desc
limit 5
