import {ComponentFixture, TestBed} from '@angular/core/testing'
import {MasterlistComponent} from './masterlist.component'

describe('MasterlistComponent', () => {
  let fixture: ComponentFixture<MasterlistComponent>

  beforeEach(() => {
    TestBed.configureTestingModule({declarations: [ MasterlistComponent ]})
    fixture = TestBed.createComponent(MasterlistComponent)
  })

  it('displays movie name and add to list buttons', () => {
    const component = fixture.componentInstance
    component.movies = [{id: 1, name: 'test movie'}]
    component.wishlistIds = []
    component.watchedlistIds = []

    fixture.detectChanges()

    const listText = fixture.nativeElement.querySelector('.list').textContent
    expect(listText).toContain('test movie')
    expect(listText).toContain('Add to Wish List')
    expect(listText).toContain('Add to Watched List')
  })

  it('displays movie name without add to list buttons if included in wishlist', () => {
    const component = fixture.componentInstance
    component.movies = [{id: 1, name: 'test movie'}]
    component.wishlistIds = [1]
    component.watchedlistIds = []

    fixture.detectChanges()

    const listText = fixture.nativeElement.querySelector('.list').textContent
    expect(listText).toContain('test movie')
    expect(listText).not.toContain('Add to Wish List')
    expect(listText).not.toContain('Add to Watched List')
  })

  it('displays movie name without add to list buttons if included in watchedlist', () => {
    const component = fixture.componentInstance
    component.movies = [{id: 1, name: 'test movie'}]
    component.wishlistIds = []
    component.watchedlistIds = [1]

    fixture.detectChanges()

    const listText = fixture.nativeElement.querySelector('.list').textContent
    expect(listText).toContain('test movie')
    expect(listText).not.toContain('Add to Wish List')
    expect(listText).not.toContain('Add to Watched List')
  })
})
