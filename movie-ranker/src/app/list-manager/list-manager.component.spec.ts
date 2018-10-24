import {ComponentFixture, TestBed} from '@angular/core/testing'

import {ListManagerComponent} from './list-manager.component'
import {MasterlistComponent} from '../masterlist/masterlist.component'
import {WishlistComponent} from '../wishlist/wishlist.component'
import {WatchedlistComponent} from '../watchedlist/watchedlist.component'
import {MasterlistService} from '../masterlist/masterlist.service'
import {of} from 'rxjs'
import {WishlistService} from '../wishlist/wishlist.service'
import {WatchedlistService} from '../watchedlist/watchedlist.service'

describe('ListManagerComponent', () => {
  let fixture: ComponentFixture<ListManagerComponent>
  let stubMasterlistService
  let stubWishlistService
  let stubWatchedlistService

  beforeEach(() => {
    stubMasterlistService = jasmine.createSpyObj(['getAll'])
    stubWishlistService = jasmine.createSpyObj(['getAll', 'add', 'remove'])
    stubWatchedlistService = jasmine.createSpyObj(['getAll', 'add', 'remove'])

    TestBed.configureTestingModule({
      declarations: [
        ListManagerComponent,
        MasterlistComponent,
        WishlistComponent,
        WatchedlistComponent
      ],
      providers: [
        {provide: MasterlistService, useValue: stubMasterlistService },
        {provide: WishlistService, useValue: stubWishlistService },
        {provide: WatchedlistService, useValue: stubWatchedlistService }
      ]
    })

    stubMasterlistService.getAll.and.returnValue(of([]))
    stubWishlistService.getAll.and.returnValue(of([]))
    stubWishlistService.add.and.returnValue(of([]))
    stubWishlistService.remove.and.returnValue(of([]))
    stubWatchedlistService.getAll.and.returnValue(of([]))
    stubWatchedlistService.add.and.returnValue(of([]))
    stubWatchedlistService.remove.and.returnValue(of([]))

    fixture = TestBed.createComponent(ListManagerComponent)
  })

  it('displays data in masterlist', () => {
    stubMasterlistService.getAll.and.returnValue(of([{id: 1, name: 'movie 1'}, {id: 2, name: 'movie 2'}]))

    fixture.detectChanges()

    const element = fixture.nativeElement
    expect(element.querySelector('.masterlist').textContent).toContain('movie 1')
    expect(element.querySelector('.masterlist').textContent).toContain('movie 2')
    expect(element.querySelector('.wishlist').textContent).not.toContain('movie 1')
    expect(element.querySelector('.wishlist').textContent).not.toContain('movie 2')
    expect(element.querySelector('.watchedlist').textContent).not.toContain('movie 1')
    expect(element.querySelector('.watchedlist').textContent).not.toContain('movie 2')
  })

  it('displays data in wishlist', () => {
    stubWishlistService.getAll.and.returnValue(of([{id: 1, name: 'movie 1'}, {id: 2, name: 'movie 2'}]))

    fixture.detectChanges()

    const element = fixture.nativeElement
    expect(element.querySelector('.masterlist').textContent).not.toContain('movie 1')
    expect(element.querySelector('.masterlist').textContent).not.toContain('movie 2')
    expect(element.querySelector('.wishlist').textContent).toContain('movie 1')
    expect(element.querySelector('.wishlist').textContent).toContain('movie 2')
    expect(element.querySelector('.watchedlist').textContent).not.toContain('movie 1')
    expect(element.querySelector('.watchedlist').textContent).not.toContain('movie 2')
  })

  it('displays data in watchedlist', () => {
    stubWatchedlistService.getAll.and.returnValue(of([{id: 1, name: 'movie 1'}, {id: 2, name: 'movie 2'}]))

    fixture.detectChanges()

    const element = fixture.nativeElement
    expect(element.querySelector('.masterlist').textContent).not.toContain('movie 1')
    expect(element.querySelector('.masterlist').textContent).not.toContain('movie 2')
    expect(element.querySelector('.wishlist').textContent).not.toContain('movie 1')
    expect(element.querySelector('.wishlist').textContent).not.toContain('movie 2')
    expect(element.querySelector('.watchedlist').textContent).toContain('movie 1')
    expect(element.querySelector('.watchedlist').textContent).toContain('movie 2')
  })

  it('', () => {
    stubMasterlistService.getAll.and.returnValue(of([{id: 1, name: 'movie 1'}, {id: 2, name: 'movie 2'}]))

    fixture.detectChanges()

    const element = fixture.nativeElement
    element.querySelector('.masterlist').querySelector('button').click()

    expect(stubWishlistService.add).toHaveBeenCalled()
  })
})
