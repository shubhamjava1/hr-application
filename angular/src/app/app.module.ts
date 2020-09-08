import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {RouterModule} from '@angular/router';
import {FormsModule} from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { AboutComponent } from './about/about.component';
import { ContactComponent } from './contact/contact.component';
import { HomeComponent } from './job/job.component';
import { ContactFormComponent } from './contact-form/contact-form.component';
import { DirectiveTypeComponent } from './directive-type/directive-type.component';
import { StructuralDirectiveComponent } from './structural-directive/structural-directive.component';
import { AttributeDirectiveComponent } from './attribute-directive/attribute-directive.component';
import { PipeTypeComponent } from './pipe-type/pipe-type.component';
import { ServiceTypeComponent } from './service-type/service-type.component';
import { ShowDateTimeComponent } from './show-date-time/show-date-time.component';

@NgModule({
  declarations: [
    AppComponent,
    AboutComponent,
    ContactComponent,
    HomeComponent,
    ContactFormComponent,
    DirectiveTypeComponent,
    StructuralDirectiveComponent,
    AttributeDirectiveComponent,
    PipeTypeComponent,
    ServiceTypeComponent,
    ShowDateTimeComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    RouterModule.forRoot([
      {
        path:'job',
        component: HomeComponent
      },
      {
        path:'about',
        component: AboutComponent
      },
      {
        path:'contact',
        component: ContactComponent
      },
      {
        path: 'directive',
        component: DirectiveTypeComponent
      },
      {
        path:'pipe',
        component: PipeTypeComponent
      },
      {
        path:'service',
        component: ServiceTypeComponent
      },
      {
        path: 'department',
        component: ContactFormComponent
      }
    ]),
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
