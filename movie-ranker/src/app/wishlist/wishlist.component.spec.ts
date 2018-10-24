import {ComponentFixture, TestBed} from '@angular/core/testing'
import {WishlistComponent} from './wishlist.component'

describe('WishlistComponent', () => {
  let fixture: ComponentFixture<WishlistComponent>

  beforeEach(() => {
    TestBed.configureTestingModule({declarations: [ WishlistComponent ]})
    fixture = TestBed.createComponent(WishlistComponent)
  })

  it('displays movie with Watched and Remove buttons', () => {
    const component = fixture.componentInstance
    component.movies = [{id: 1, name: 'test movie'}]

    fixture.detectChanges()

    const listText = fixture.nativeElement.querySelector('.list').textContent
    expect(listText).toContain('test movie')
    expect(listText).toContain('Watched')
    expect(listText).toContain('Remove')
  })
})
