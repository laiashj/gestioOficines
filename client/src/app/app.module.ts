
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { MaterialModule } from './material.module';
import { FormsModule } from '@angular/forms';
import { TecnicService } from './shared/tecnic/tecnic.service';
import { HttpClientModule } from '@angular/common/http';
import { TecnicListComponent } from './tecnic-list/tecnic-list.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { AfegirTecnicComponent } from './afegir-tecnic/afegir-tecnic.component';
import { ModificarTecnicComponent } from './modificar-tecnic/modificar-tecnic.component';
import { AfegirProjecteComponent} from './afegir-projecte/afegir-projecte.component';
import { ModificarLlocComponent} from './modificar-lloc/modificar-lloc.component';
import { ModificarProjecteComponent} from './modificar-projecte/modificar-projecte.component';
import { LoginComponent} from './login/login.component';
import { UserComponent} from './user/user.component';
import { UserService} from './user.service';
import { AuthguardGuard} from './authguard.guard';


const appRoutes: Routes = [
{path: '', component: LoginComponent},
{path: 'user', canActivate: [AuthguardGuard], component: UserComponent},
{path: 'tecnics', component: TecnicListComponent },
{path: 'afegirtecnic', component: AfegirTecnicComponent},
{path: 'modificartecnic', component: ModificarTecnicComponent},
{path: 'afegirprojecte', component: AfegirProjecteComponent},
{path: 'modificarprojecte', component: ModificarProjecteComponent},
{path: 'modificarlloc', component: ModificarLlocComponent}
];
@NgModule({
  declarations: [
	TecnicListComponent,
	AfegirTecnicComponent,
	ModificarTecnicComponent,
	AfegirProjecteComponent,
	ModificarLlocComponent,
	ModificarProjecteComponent,
    AppComponent,
	LoginComponent,
	UserComponent
	
  ],
  imports: [
    BrowserModule,
	HttpClientModule,
	MaterialModule, 
	FormsModule,
	BrowserAnimationsModule,
	RouterModule.forRoot(
	appRoutes)
	],
  providers: [TecnicService, UserService, AuthguardGuard],
  bootstrap: [AppComponent]
})
export class AppModule { }
