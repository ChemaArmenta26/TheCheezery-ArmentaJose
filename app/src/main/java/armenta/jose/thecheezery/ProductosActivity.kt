package armenta.jose.thecheezery

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList

class ProductosActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_productos)
        val imageTitle : ImageView = findViewById(R.id.ImageTitle) as ImageView
        val category = intent.getStringExtra("CATEGORY")

        val productList = when (category) {
            "cold_drinks" -> {
                imageTitle.setImageResource(R.drawable.colddrinks)
                getColdDrinks()
            }
            "hot_drinks" -> {
                imageTitle.setImageResource(R.drawable.hotdrinks)
                getHotDrinks()
            }
            "sweets" -> {
                imageTitle.setImageResource(R.drawable.sweets)
                getSweets()
            }
            "salties" -> {
                imageTitle.setImageResource(R.drawable.salties)
                getSalties()
            }
            else -> ArrayList()
        }

        val listView = findViewById<ListView>(R.id.listView)
        val adapter = AdaptadorProductos(this, productList)

        listView.adapter = adapter
    }

    private fun getHotDrinks(): ArrayList<Product> {
        return arrayListOf(
            Product("Latte", R.drawable.latte, "Coffee drink with steamed milk.", 6.0),
            Product("Hot chocolate", R.drawable.hotchocolate, "Chocolate drink with marshmallows.", 5.0),
            Product("Espresso", R.drawable.espresso, "Concentrated coffee.", 4.0),
            Product("Chai Latte", R.drawable.chailatte, "Spiced tea concentrate with milk.", 6.0),
            Product("Cappuccino", R.drawable.capuccino, "Espresso with steamed foam.", 7.0),
            Product("American coffee", R.drawable.americano, "Espresso with hot water.", 2.0)
        )
    }

    private fun getSweets(): ArrayList<Product> {
        return arrayListOf(
            Product("Blueberry cake", R.drawable.blueberrycake, "Vanilla cake with blueberries.", 6.0),
            Product("Chocolate cupcake", R.drawable.chocolatecupcake, "Cupcakes with butter cream.", 3.0),
            Product("Lemon tartalette", R.drawable.lemontartalette, "Pastry shell with lemon filling.", 4.0),
            Product("Red Velvet cake", R.drawable.redvelvetcake, "Moist buttery cake with cream cheese frosting.", 6.0),
            Product("Cherry cheesecake", R.drawable.strawberrycheesecake, "Cheesecake topped with cherries.", 7.0),
            Product("Tiramisu", R.drawable.tiramisu, "Coffee-flavored Italian dessert.", 6.0)
        )
    }

    private fun getSalties(): ArrayList<Product> {
        return arrayListOf(
            Product("Chicken crepes", R.drawable.chickencrepes, "Crepes stuffed with chicken, spinach, and mushrooms.", 6.0),
            Product("Club Sandwich", R.drawable.clubsandwich, "Sandwich served with french fries.", 5.0),
            Product("Panini", R.drawable.hampanini, "Grilled Italian bread sandwich.", 4.0),
            Product("Philly cheese steak", R.drawable.phillycheesesteak, "Steak with onions, peppers, and cheese.", 6.0),
            Product("Nachos", R.drawable.nachos, "Tortilla chips with cheese and toppings.", 7.0)
        )
    }

    fun getColdDrinks(): ArrayList<Product> {
        return arrayListOf(
            Product("Caramel Frap", R.drawable.caramelfrap, "Caramel syrup meets coffee, milk and ice and whipped cream and buttery caramel sauce layer the love on top.", 5.0),
            Product("Chocolate Frap", R.drawable.chocolatefrap, "Rich mocha-flavored sauce meets up with chocolaty chips, milk and ice for a blender bash.", 6.0),
            Product("Cold Brew", R.drawable.coldbrew, "Created by steeping medium-to-coarse ground coffee in room temperature water for 12 hours or longer.", 3.0),
            Product("Matcha Latte", R.drawable.matcha, "Leafy taste of matcha green tea powder with creamy milk and a little sugar for a flavor balance that will leave you feeling ready and raring to go.", 4.0),
            Product("Oreo Milkshake", R.drawable.oreomilkshake, "Chocolate ice cream, and oreo cookies. Topped with whipped cream with cocoa and chocolate syrup.", 7.0),
            Product("Peanut Milkshake", R.drawable.peanutmilkshake, "Vanilla ice cream, mixed with peanut butter and chocolate.", 7.0)
        )
    }

    private class AdaptadorProductos : BaseAdapter{
        var productos = ArrayList<Product>()
        var contexto : Context? = null

        constructor(contexto: Context, productos: ArrayList<Product>){
            this.productos = productos
            this.contexto = contexto
        }

        override fun getCount(): Int {
            return productos.size
        }

        override fun getItem(position: Int): Any {
            return productos[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var producto = productos[position]
            var inflador = LayoutInflater.from(contexto)
            var vista = inflador.inflate(R.layout.producto_view, null)

            var imagen = vista.findViewById(R.id.productoImg) as ImageView
            var nombre = vista.findViewById(R.id.producto_nombre) as TextView
            var descripcion = vista.findViewById(R.id.producto_descripcion) as TextView
            var precio = vista.findViewById(R.id.producto_precio) as TextView

            imagen.setImageResource(producto.image)
            nombre.setText(producto.name)
            descripcion.setText(producto.description)
            precio.setText("$${producto.price}")

            return vista
        }
    }
}