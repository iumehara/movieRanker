import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core'
import {Movie} from '../Movie'
import {WishlistService} from '../wishlist/wishlist.service'

@Component({
  selector: 'app-masterlist',
  templateUrl: './masterlist.component.html',
  styleUrls: ['./masterlist.component.scss']
})

export class MasterlistComponent implements OnInit {
  constructor(private wishlistService: WishlistService) { }

  @Input() movies: Movie[]
  @Input() wishlistIds: number[]
  @Output() messageEvent = new EventEmitter<string>()

  ngOnInit() {}

  addToWishlist(movie: Movie) {
    this.wishlistService.add(movie)
    this.messageEvent.emit('WISHLIST_UPDATED')
  }
}
