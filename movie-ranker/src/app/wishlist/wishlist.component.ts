import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core'
import {WishlistService} from './wishlist.service'
import {Movie} from '../Movie'
import {WatchedlistService} from '../watchedlist/watchedlist.service'

@Component({
  selector: 'app-wishlist',
  templateUrl: './wishlist.component.html',
  styleUrls: ['./wishlist.component.css']
})

export class WishlistComponent implements OnInit {
  constructor(
    private wishlistService: WishlistService,
    private watchedlistService: WatchedlistService
  ) { }

  @Input() movies: Movie[]
  @Output() messageEvent = new EventEmitter<string>()

  ngOnInit() {}

  removeFromWishlist(movie: Movie) {
    this.wishlistService.remove(movie)
    this.messageEvent.emit('WISHLIST_UPDATED')
  }

  moveToWatchedList(movie: Movie) {
    this.wishlistService.remove(movie)
    this.watchedlistService.add(movie)
    this.messageEvent.emit('WISHLIST_UPDATED')
    this.messageEvent.emit('WATCHEDLIST_UPDATED')
  }
}
