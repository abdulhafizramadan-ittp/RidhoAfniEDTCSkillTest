package com.ridhoafnidev.edtc.feature.home

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import coil.load
import coil.transform.CircleCropTransformation
import com.afollestad.recyclical.datasource.dataSourceOf
import com.afollestad.recyclical.setup
import com.afollestad.recyclical.withItem
import com.ridhoafnidev.edtc.core_data.domain.Event
import com.ridhoafnidev.edtc.core_data.domain.ListEvents
import com.ridhoafnidev.edtc.core_data.domain.MenuStatus
import com.ridhoafnidev.edtc.core_domain.model.Menu
import com.ridhoafnidev.edtc.core_navigation.ModuleNavigator
import com.ridhoafnidev.edtc.core_resource.components.base.BaseFragment
import com.ridhoafnidev.edtc.core_util.dayTimeGreeting
import com.ridhoafnidev.edtc.feature.home.viewholder.ItemCurrentEventViewHolder
import com.ridhoafnidev.edtc.feature.home.viewholder.ItemMenuViewHolder
import com.ridhoafnidev.edtc.feature.home.viewholder.ItemNewEventViewHolder
import com.ridhoafnidev.home.R
import com.ridhoafnidev.home.databinding.FragmentHomeBinding
import com.ridhoafnidev.edtc.core_util.setSnapHelper
import lt.neworld.spanner.Spanner
import lt.neworld.spanner.Spans.bold
import org.koin.androidx.viewmodel.ext.android.viewModel


class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate), ModuleNavigator {

    private val itemsMenu by lazy {
        listOf(
            Menu(
                1,
                "Buat Event",
                R.drawable.ic_create_event
            ),
            Menu(
                2,
                "Event Saya",
                R.drawable.ic_my_event
            ),
            Menu(
                3,
                "Daftar Karyawan",
                R.drawable.ic_employe
            ),
            Menu(
                4,
                "Reservasi Meeting",
                R.drawable.ic_reservation
            ),
            Menu(
                5,
                "Pengajuan Cuti",
                R.drawable.ic_paid_leave
            ),
            Menu(
                6,
                "Absensi",
                R.drawable.ic_attendance
            )
        )
    }

    private val itemsNewEvent by lazy {
        listOf(
            Event(
                id = 1,
                name = "Android Training Day 1",
                location = "Conference Room",
                startDate = "13 July",
                startTime = "9.00 AM",
                endDate = "",
                endTime = "",
                image = R.drawable.image_5,
                description = "",
                poweredBy = "Elevenia F30"
            ),
            Event(
                id = 1,
                name = "Android Training Day 2",
                location = "Conference Room",
                startDate = "13 July",
                startTime = "10.00 AM",
                endDate = "",
                endTime = "",
                image = R.drawable.image_6,
                description = "",
                poweredBy = "Elevenia F30"
            ),
            Event(
                id = 1,
                name = "Android Training Day 3",
                location = "Conference Room",
                startDate = "13 July",
                startTime = "10.00 AM",
                endDate = "",
                endTime = "",
                image = R.drawable.image_7,
                description = "",
                poweredBy = "Elevenia F30"
            ),
            Event(
                id = 1,
                name = "Android Training Day 4",
                location = "Conference Room",
                startDate = "16 July",
                startTime = "11.00 AM",
                endDate = "",
                endTime = "",
                image = R.drawable.image_8,
                description = "",
                poweredBy = "Elevenia F30"
            ),
            Event(
                id = 1,
                name = "Android Training Day 5",
                location = "Conference Room",
                startDate = "17 July",
                startTime = "12.00 AM",
                endDate = "",
                endTime = "",
                image = R.drawable.image_9,
                description = "",
                poweredBy = "Elevenia F30"
            )
        )
    }

    private val homeViewModel: HomeViewModel by viewModel()

    private val recyclerViewMenus by lazy { binding.rvGridMenu }

    private val recyclerViewNewEvents by lazy { binding.rvNewEvent }

    private val recyclerViewCurrentEvents by lazy { binding.rvCurrentEvent }

    override fun initView() {
        getEvent()
        setupEvent()
        setupItems()
        setupMenus()
        setupCurrentEvents()
    }

    private fun getEvent() {
        homeViewModel.getEvent()
    }

    private fun setupEvent() {
        homeViewModel.newEvent.observe(viewLifecycleOwner) { listEvent ->
            if (listEvent != null) {
                setupNewEvents(listEvent)
            }
        }
    }

    private fun setupItems() {
        with(binding){
            tvWelcome.text = Spanner().append("Halo ")
                .append("${dayTimeGreeting(requireContext())}, \n")
                .append("John Doe Simalakama", bold())

            ivUser.load(R.drawable.photo_male){
                crossfade(true)
                transformations(CircleCropTransformation())
            }
        }
    }

    private fun setupNewEvents(listEvents: ListEvents) {
        recyclerViewNewEvents.setup {
            withLayoutManager(LinearLayoutManager(context))
            withDataSource(dataSourceOf(listEvents))
            withItem<Event, ItemNewEventViewHolder>(R.layout.layout_item_new_event){
                onBind(::ItemNewEventViewHolder){_, item ->
                    imageEvent.load(item.image)
                    titleEvent.text = item.name
                    timestampEvent.text = item.startDate
                    placeEvent.text = item.location
                }
            }
        }
    }

    private fun setupCurrentEvents() {
        setSnapHelper(recyclerViewCurrentEvents)
        recyclerViewCurrentEvents.setup {
            withLayoutManager(LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false))
            withDataSource(dataSourceOf(itemsNewEvent.filter { it.startDate == "13 July" }))
            withItem<Event, ItemCurrentEventViewHolder>(R.layout.layout_item_current_event){
                onBind(::ItemCurrentEventViewHolder){_, item ->
                    imageEvent.load(item.image)
                    titleEvent.text = item.name
                    dateEvent.text = item.startDate.take(2)
                    mounthEvent.text = item.startDate.takeLast(4)
                    placeEvent.text = item.location
                }
            }
        }
    }

    private fun setupMenus() {
        recyclerViewMenus.setup {
            withLayoutManager(GridLayoutManager(context, 4))
            withDataSource(dataSourceOf(itemsMenu))
            withItem<Menu, ItemMenuViewHolder>(R.layout.layout_item_menu){
                onBind(::ItemMenuViewHolder){_, item ->
                    titleMenu.text = item.title
                    ivMenu.load(item.image)
                    ivMenu.setOnClickListener {
                        when(item.id){
                            MenuStatus.CreateEvent() -> {
                                navigateToCreateEventActivity()
                            }
                        }
                    }
                }
            }
        }
    }

    override fun initListener(){
    }
}