package com.example.foodapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.food_ticket.view.*

class MainActivity : AppCompatActivity() {
    var adapter: foodAdapter?=null
    var listOfFoods = ArrayList<Food>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       listOfFoods.add(
       Food("coffee","When people think of coffee, they usually think of its ability to provide an energy boost.",R.drawable.coffee_pot)
       )
        listOfFoods.add(
            Food("espresso","Espresso is a concentrated form of coffee served in small, strong shots and is the base for many coffee drinks. It's made from the same beans as coffee but is stronger, thicker, and higher in caffeine. However, because espresso is typically served in smaller servings than coffee, it has less caffeine per serving.",R.drawable.espresso)
        )
        listOfFoods.add(
            Food("french_fries","French fries are prepared by first cutting the potato (peeled or unpeeled) into even strips",R.drawable.french_fries)
        )
        listOfFoods.add(
            Food("honey","Honey may be better than conventional treatments for coughs, blocked noses and sore throats, researchers have said. The substance is cheap, readily available, and has virtually no side-effects.",R.drawable.honey)
        )
        listOfFoods.add(
            Food("strawberry_ice_cream","This Homemade Strawberry Ice Cream is creamy, dreamy, and made with fresh strawberries. It’s an old fashioned strawberry ice cream recipe that makes it the perfect spring or summer dessert.",R.drawable.strawberry_ice_cream)
        )
        listOfFoods.add(
            Food("sugar","I’ve been studying the role that sugar plays in contributing to chronic disease for years, and my research group at the University of California, San Francisco has just published research in the journal Obesity that challenges this assumption",R.drawable.sugar_cubes)
        )
        adapter = foodAdapter(this,listOfFoods)
        gvListFood.adapter=adapter
    }

    class foodAdapter:BaseAdapter{
        var listOfFood = ArrayList<Food>()
        var context:Context? = null
        constructor(context: Context,listOfFood: ArrayList<Food>):super(){
            this.context=context
            this.listOfFood=listOfFood
        }
        override fun getCount(): Int {
             return listOfFood.size
        }

        override fun getItem(p0: Int): Any {
            return listOfFood[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            val food = this.listOfFood[p0]
            var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var foodView = inflator.inflate(R.layout.food_ticket,null)
            foodView.ivFoodImage.setImageResource(food.image!!)
            foodView.ivFoodImage.setOnClickListener{
                val intent = Intent(context,FoodDetails::class.java)
                intent.putExtra("name",food.name!!)
                intent.putExtra("des",food.des!!)
                intent.putExtra("image",food.image!!)
                context!!.startActivity(intent)
            }
            foodView.tvName.text = food.name!!
            return foodView
        }

    }


}