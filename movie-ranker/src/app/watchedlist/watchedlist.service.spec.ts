import {fakeAsync} from '@angular/core/testing'

import {WatchedlistService} from './watchedlist.service'


describe('WatchedlistService', () => {
  it('is empty by default', fakeAsync(() => {
    const watchedlistService = new WatchedlistService()

    let movies
    watchedlistService.getAll()
      .subscribe(value => movies = value)

    expect(movies.length).toBe(0)
  }))

  it('can add movies', fakeAsync(() => {
    const watchedlistService = new WatchedlistService()

    const movieToAdd = {id: 1, name: 'my movie'}
    watchedlistService.add(movieToAdd)

    let movies
    watchedlistService.getAll()
      .subscribe(value => movies = value)
    expect(movies.length).toBe(1)
    expect(movies[0].id).toBe(1)
    expect(movies[0].name).toBe('my movie')
  }))

  it('can add two movies', fakeAsync(() => {
    const watchedlistService = new WatchedlistService()
    const movieToAdd1 = {id: 1, name: 'my movie 1'}
    const movieToAdd2 = {id: 2, name: 'my movie 2'}

    watchedlistService.add(movieToAdd1)
    watchedlistService.add(movieToAdd2)

    let movies
    watchedlistService.getAll()
      .subscribe(value => movies = value)
    expect(movies.length).toBe(2)
    expect(movies[1].id).toBe(2)
    expect(movies[1].name).toBe('my movie 2')
  }))

  it('can remove movie', fakeAsync(() => {
    const watchedlistService = new WatchedlistService()
    const movie1 = {id: 1, name: 'my movie 1'}
    const movie2 = {id: 2, name: 'my movie 2'}
    watchedlistService.add(movie1)
    watchedlistService.add(movie2)

    watchedlistService.remove(movie1)

    let movies
    watchedlistService.getAll()
      .subscribe(value => movies = value)
    expect(movies.length).toBe(1)
    expect(movies[0].id).toBe(2)
    expect(movies[0].name).toBe('my movie 2')
  }))
})
