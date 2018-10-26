import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {MasterlistComponent} from './masterlist/masterlist.component';
import {ListManagerComponent} from './list-manager/list-manager.component';
import {WishlistComponent} from './wishlist/wishlist.component';
import {WatchedlistComponent} from './watchedlist/watchedlist.component';
import {HttpClientModule} from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    ListManagerComponent,
    MasterlistComponent,
    WishlistComponent,
    WatchedlistComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
