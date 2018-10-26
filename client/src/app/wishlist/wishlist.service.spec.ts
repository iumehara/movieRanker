import {fakeAsync} from '@angular/core/testing'
import {WishlistService} from './wishlist.service'

describe('WishlistService', () => {
  it('is empty by default', fakeAsync(() => {
    const wishlistService = new WishlistService()

    let movies
    wishlistService.getAll()
      .subscribe(value => movies = value)

    expect(movies.length).toBe(0)
  }))

  it('can add movies', fakeAsync(() => {
    const wishlistService = new WishlistService()

    const movieToAdd = {id: 1, name: 'my movie'}
    wishlistService.add(movieToAdd)

    let movies
    wishlistService.getAll()
      .subscribe(value => movies = value)
    expect(movies.length).toBe(1)
    expect(movies[0].id).toBe(1)
    expect(movies[0].name).toBe('my movie')
  }))

  it('can add two movies', fakeAsync(() => {
    const wishlistService = new WishlistService()
    const movieToAdd1 = {id: 1, name: 'my movie 1'}
    const movieToAdd2 = {id: 2, name: 'my movie 2'}

    wishlistService.add(movieToAdd1)
    wishlistService.add(movieToAdd2)

    let movies
    wishlistService.getAll()
      .subscribe(value => movies = value)
    expect(movies.length).toBe(2)
    expect(movies[1].id).toBe(2)
    expect(movies[1].name).toBe('my movie 2')
  }))

  it('can remove movie', fakeAsync(() => {
    const wishlistService = new WishlistService()
    const movie1 = {id: 1, name: 'my movie 1'}
    const movie2 = {id: 2, name: 'my movie 2'}
    wishlistService.add(movie1)
    wishlistService.add(movie2)

    wishlistService.remove(movie1)

    let movies
    wishlistService.getAll()
      .subscribe(value => movies = value)
    expect(movies.length).toBe(1)
    expect(movies[0].id).toBe(2)
    expect(movies[0].name).toBe('my movie 2')
  }))
})
