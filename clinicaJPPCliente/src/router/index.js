import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import App from '../App.vue'
import ListaClientes from '../components/ListaClientes.vue'
import ListaVeterinarios from '../components/ListaVeterinarios.vue'
import ListaMascotas from '../components/ListaMascotas.vue'
import EditarCliente from '../components/EditarCliente.vue'
import EditarVeterinario from '../components/EditarVeterinario.vue'
import EditarMascota from '../components/EditarMascota.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [

    {
      path: '/clientes',
      name: 'lista-clientes',
      component: ListaClientes
    },
    {
      path: '/veterinarios',
      name: 'lista-veterinarios',
      component: ListaVeterinarios
    },
    {
      path: '/mascotas',
      name: 'lista-mascotas',
      component: ListaMascotas
    },
    {
      path: '/editar-cliente',
      name: 'editar-cliente',
      component: EditarCliente
    },
    {
      path: '/editar-veterinario',
      name: 'editar-veterinario',
      component: EditarVeterinario
    },
    {
      path: '/editar-mascota',
      name: 'editar-mascota',
      component: EditarMascota
    }
  ]
})

export default router