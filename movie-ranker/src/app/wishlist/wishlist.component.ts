import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core'
import {WishlistService} from './wishlist.service'
import {Movie} from '../Movie'

@Component({
  selector: 'app-wishlist',
  templateUrl: './wishlist.component.html',
  styleUrls: ['./wishlist.component.css']
})

export class WishlistComponent implements OnInit {
  constructor(private wishlistService: WishlistService) { }

  @Input() movies: Movie[]
  @Output() messageEvent = new EventEmitter<string>()

  ngOnInit() {}

  removeFromWishlist(movie: Movie) {
    this.wishlistService.remove(movie)
    this.messageEvent.emit('WISHLIST_UPDATED')
  }
}
