package com.example.hw3_8

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.hw3_8.databinding.FragmentCardsBinding

class CardsFragment : Fragment(), OnClick {
    private val cardList = arrayListOf(
        Card(R.drawable.rick, "Alive", "Rick Sanchez"),
        Card(R.drawable.morty, "Alive", "Morty Smith"),
        Card(R.drawable.albert_einstein, "Dead", "Albert Einstein"),
        Card(R.drawable.jerry_smith, "Dead", "Jerry Smith")
    )

    private lateinit var binding: FragmentCardsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCardsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = CardsAdapter(cardList, this)
        binding.rvCharacterCards.adapter = adapter


    }
    override fun onClick(card: Card) {
        val bundle = bundleOf("selectedCard" to card)
        findNavController().navigate(R.id.detailFragment, bundle)
    }
}