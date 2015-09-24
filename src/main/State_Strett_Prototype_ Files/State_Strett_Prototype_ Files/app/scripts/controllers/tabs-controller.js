'use strict';

/**
 * @ngdoc function
 * @name stateStreetPrototypeApp.controller:TabsCtrl
 * @description
 * # TabsCtrl
 * Controller of the stateStreetPrototypeApp
 */

angular.module('stateStreetPrototypeApp')
  .controller('TabsCtrl', function ($scope) {
  	//TODO temporaray data
    $scope.menuItems = [
        {
            id: 1,
            name: "Import Data",
            subMenu:[
            	{
            		name:'IGLS Balance',
            		key:'bal',// TODO,
            		url:'balance'
            	},
            	{	
            		name:'IGLS SOI',
            		key: 'SOI', // todo
            		url:'soi'
            	}
            ] 
        },
        {
            id: 2,
            name: "View Raw Data",
            subMenu:[
            	{
            		name:'IGLS Balance',
            		key:'bal', // TODO
            		url:'balance'
            	},
            	{	
            		name:'IGLS SOI',
            		key: 'SOI', // todo
            		url:'soi'
            	}
            ] 
        },
        {
            id: 3,
            name: "View Consolidated Data",
            subMenu:[
            	{
            		name:'IGLS Balance',
            		key:'bal', // TODO
            		url:'balance'
            	},
            	{	
            		name:'IGLS SOI',
            		key: 'SOI', // todo
            		url:'soi'
            	}
            ] 
        },
        {
            id: 4,
            name: "Export Data",
            subMenu:[
            	{
            		name:'IGLS Balance',
            		key:'bal', // TODO
            		url:'balance'
            	},
            	{	
            		name:'IGLS SOI',
            		key: 'SOI', // todo
            		url:'soi'
            	}
            ] 
        }
    ];
});




