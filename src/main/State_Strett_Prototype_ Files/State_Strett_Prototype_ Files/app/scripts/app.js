'use strict';

/**
 * @ngdoc overview
 * @name stateStreetPrototypeApp
 * @description
 * # stateStreetPrototypeApp
 *
 * Main module of the application.
 */
angular
  .module('stateStreetPrototypeApp', [
    'ui.router',
    'mm.foundation'
  ])
  .config(['$stateProvider',
    function($stateProvider) {

      $stateProvider
        .state('root',{
          url: '/'
        })
        .state('root.balance', {
          url: 'balance',
          templateUrl: 'views/table-data.html'
        })
        .state('root.soi', {
          url: 'soi',
          templateUrl: 'views/table-data.html'
        });

    }
  ]);
