import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core'
import {Movie} from '../Movie'
import {WishlistService} from '../wishlist/wishlist.service'
import {WatchedlistService} from '../watchedlist/watchedlist.service'

@Component({
  selector: 'app-masterlist',
  templateUrl: './masterlist.component.html',
  styleUrls: ['./masterlist.component.scss']
})

export class MasterlistComponent implements OnInit {
  constructor(
    private wishlistService: WishlistService,
    private watchedlistService: WatchedlistService
  ) { }

  @Input() movies: Movie[]
  @Input() wishlistIds: number[]
  @Input() watchedlistIds: number[]
  @Output() messageEvent = new EventEmitter<string>()

  ngOnInit() {}

  addToWishlist(movie: Movie) {
    this.wishlistService.add(movie)
    this.messageEvent.emit('WISHLIST_UPDATED')
  }

  addToWatchedlist(movie: Movie) {
    this.watchedlistService.add(movie)
    this.messageEvent.emit('WATCHEDLIST_UPDATED')
  }
}
